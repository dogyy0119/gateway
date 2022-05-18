package com.chinamobile.ln.cloud.gis.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.MalformedURLException;

/**日志过滤器
 * @author: HuangFu
 * @date: 2020/1/20
 **/
@Component
public class LogFilter implements GlobalFilter, Ordered {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        try {
            logger.info("收到请求：method={}, url={}", exchange.getRequest().getMethodValue(), exchange.getRequest().getURI().toURL().toString());
        } catch (MalformedURLException e) {
            logger.error("url解析错误：", e);
        }

        return chain.filter(exchange).then( Mono.fromRunnable(() ->
            logger.info("请求结束")
        ));

    }

    @Override
    public int getOrder() {
        return -100;
    }
}
