package com.example.zuul;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RequestLimiterFilter implements Filter {
    private static final int MAX_REQUESTS_PER_SECOND = 5; // 服务器设定的请求次数上限
    private Map<String, Long> requestCountMap; // 存储每个 IP 地址的请求次数
    private Map<String, Long> requestTimestampMap; // 存储每个 IP 地址的最近一次请求时间

    @Override
    public void init(FilterConfig filterConfig) {
        requestCountMap = new HashMap<>();
        requestTimestampMap = new HashMap<>();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String ipAddress = request.getRemoteAddr(); // 获取用户的 IP 地址

        // 检查请求次数是否超过限制
        if (isAllowed(ipAddress)) {
            filterChain.doFilter(request, response); // 请求次数未超过限制，允许访问
            incrementRequestCount(ipAddress);
        } else {
            // 如果请求次数超过限制，拒绝访问
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("请求次数超出限制");
        }
    }

    @Override
    public void destroy() {
        requestCountMap.clear();
        requestTimestampMap.clear();
    }

    private boolean isAllowed(String ipAddress) {
        long currentTimeMillis = System.currentTimeMillis();
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

