package com.zephon.pub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub
 * @date 2020/7/10 下午5:32
 * @Copyright ©
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("com.zephon.pub.dao")
@EnableCaching
public class PublicServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PublicServerApplication.class,args);
    }
    /**
     * 将加密工具类加入IOC容器中,便于加密
     * */
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
