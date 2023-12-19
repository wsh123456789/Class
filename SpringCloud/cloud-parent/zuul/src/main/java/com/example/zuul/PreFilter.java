package com.example.zuul;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import com.netflix.zuul.context.RequestContext;
import java.util.Map;

@Component
public class PreFilter extends ZuulFilter {
    private static final int MAX_REQUESTS_PER_SECOND = 5; // 服务器设定的请求次数上限
    private Map<String, Long> requestCountMap = new HashMap<>();
    private Map<String, Long> requestTimestampMap = new HashMap<>();
    // 过滤类型
    @Override
    public String filterType() {
        return "pre"; // pre前置，post后置
    }

    // 过滤级别 可以为负数，数字越小，优先级越高
    @Override
    public int filterOrder() {
        return -5;
    }

    // 是否开启过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }
    // 设置令牌桶每秒数量
    // 谷歌开源代码，已经整合到了spring cloud
    private static final RateLimiter rateLimiter = RateLimiter.create(1);// 每秒放多少个令牌

    // 输出内容
    @Override
    public Object run() throws ZuulException {
        System.out.println("前置过滤器001");
        // 1. 防止恶意攻击
           // 怎么样算恶意攻击
                // 1. 大量的用户都在请求，请求超出了处理能力，对于服务器造成了很大压力，导致服务器崩溃
                    // 解决方案： 1.加保护机制，做服务降级，处理不了降级即可----异常多了就做降级。
                    //          2.可以使用令牌桶算法解决----限制请求量;
                // 2. 某个单独的用户1秒钟的请求的数据量过大，超出了服务器的处理能力
                    // 解决方案： 1. 获取用户ip,判断每个ip每秒的请求量如果请求量每秒超出服务器设定的请求次数，直接禁止访问即可
        RequestContext ctx = RequestContext.getCurrentContext();
        String ipAddress = ctx.getRequest().getRemoteAddr(); // 获取用户的 IP 地址

        // 检查请求次数是否超过限制
        if (!isAllowed(ipAddress)) {
            ctx.setSendZuulResponse(false); // 不允许转发请求
            ctx.setResponseStatusCode(429); // 设置响应状态码为 429（请求过多）
            ctx.setResponseBody("请求次数超出限制");
        } else {
            incrementRequestCount(ipAddress);
        }
                // 3. 其他：服务器的攻击，黑客的公基，防火墙被攻破，植入病毒
        // 抓包：爬虫。
        // 2. 验证登录--访问非登录接口的任意接口，判断是否登陆过
//        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attribute.getRequest();
//        String contextPath = request.getContextPath();
//        HttpSession session = request.getSession();
//        if (!contextPath.equals("/login")){
//            UserVo userVo = session.getAttribute("user");
//            if (userVo == null){
//                throw new ZuulException("请重新登录", 500 , "请重新登陆");
//            }
//        }

        // 3. 鉴权
//        String path = request.getRequestURI();
//        List<String> url = userVo.getUrlList();
//        if (!url.contains(contextPath)){
//            throw new ZuulException("权限不足", 500 , "权限不足");
//        }
        // 令牌桶算法
        if (!rateLimiter.tryAcquire()){
            throw new ZuulException("异常", 500 , "异常");
        }
        return null;
    }

    // 是否允许访问
    private boolean isAllowed(String ipAddress) {
        long currentTimeMillis = System.currentTimeMillis();
        // getOrDefault(key, default)如果存在key, 则返回其对应的value, 否则返回给定的默认值
        long previousTimestamp = requestTimestampMap.getOrDefault(ipAddress, 0L);

        // 如果距离上次请求时间超过1秒，则重置请求次数统计
        if (currentTimeMillis - previousTimestamp > 1000) {
            requestCountMap.put(ipAddress, 0L);
        }

        return requestCountMap.getOrDefault(ipAddress, 0L) < MAX_REQUESTS_PER_SECOND;
    }

    private void incrementRequestCount(String ipAddress) {

        long currentCount = requestCountMap.getOrDefault(ipAddress, 0L);
        requestCountMap.put(ipAddress, currentCount + 1);
        requestTimestampMap.put(ipAddress, System.currentTimeMillis());
    }
}
