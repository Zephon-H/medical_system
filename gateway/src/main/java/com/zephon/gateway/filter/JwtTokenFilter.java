package com.zephon.gateway.filter;

import com.nimbusds.jose.JOSEException;
import com.zephon.gateway.utils.JwtUtil;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.gateway.filter
 * @date 2020/7/12 下午5:00
 * @Copyright ©
 */
@Component
public class JwtTokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {

                ServerHttpResponse response = exchange.getResponse();
                String id = response.getHeaders().getFirst("id");
                String username = response.getHeaders().getFirst("username");
                if (id != null && username != null) {
                    try {
                        String token = JwtUtil.genToken(id, username);
                        originalResponse.getHeaders().set("access-token", token);
                    } catch (JOSEException e) {
                        e.printStackTrace();
                    }
                }
                return super.writeWith(body);
            }
        };
        return chain.filter(exchange.mutate().
                response(decoratedResponse).
                build());

}

    @Override
    public int getOrder() {
        return -2;
    }
}
