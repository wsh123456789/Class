package com.example.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class PreFilter2 extends ZuulFilter {
    // 过滤类型
    @Override
    public String filterType() {
        return "pre"; // pre前置，post后置
    }

    // 过滤级别 可以为负数，数字越小，优先级越高
    @Override
    public int filterOrder() {
        return -2;
    }

    // 是否开启过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 前置处理
    @Override
    public Object run() throws ZuulException {
        System.out.println("前置过滤器002");
        return null;
    }
}
