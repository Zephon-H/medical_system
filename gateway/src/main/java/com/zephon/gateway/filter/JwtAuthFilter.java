package com.zephon.gateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEException;
import com.zephon.common.model.Employee;
import com.zephon.gateway.utils.JwtException;
import com.zephon.gateway.utils.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.naming.NoPermissionException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.gateway.filter
 * @date 2020/7/12 下午2:19
 * @Copyright ©
 */
@Component
public class JwtAuthFilter implements GlobalFilter, Ordered {

    private String[] skipAuthUrls;
    private ObjectMapper objectMapper   ;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        String path = request.getURI().getPath();
        List<String> pages = Arrays.asList("/pub/login","/pub/logout","/pub/register");
        for (int i = 0; i < pages.size(); i++) {
            if(pages.get(i).equals(path)){
                return chain.filter(exchange);
            }
        }
        String swaggerAPI = "/v2/api-docs";
        if(path.endsWith(swaggerAPI))return chain.filter(exchange);

        String token = request.getHeaders().getFirst("access-token");
        try {
            Employee employee = JwtUtil.validToken(token);
        } catch (ParseException | JOSEException | JwtException e) {
            e.printStackTrace();
            return Mono.error(e);
        }


        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return -100;
    }
}
