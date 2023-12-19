package com.chen.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Order(-1) //设置过滤器优先级  值越小，优先级越高
//@Component  //交由spring容器进行管理
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 网关基于 WebFlux 响应式编程编写，api可能有些不一样
        //鉴权，判断用户身份
        // 1. 获取请求
        ServerHttpRequest request = exchange.getRequest();
        // 2. 获取参数中的 authorization 参数
        MultiValueMap<String, String> params = request.getQueryParams();
        // 3， 判断参数值是否等于 admin
        String auth = params.getFirst("authorization");
        // 4. 如果相等，放行 ,放开限制设置为不相等
        if (("admin".equals(auth))) {
            return chain.filter(exchange);
        }
        // 设置状态码，未登录
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        // 5，如果不等，则拦截
        return exchange.getResponse().setComplete();
    }
    @Override
    public int getOrder() {
        return -1;
    }
}
