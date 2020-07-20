package com.zephon.outpatient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.outpatient
 * @date 2020/7/17 上午10:05
 * @Copyright ©
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@EnableCaching
@MapperScan("com.zephon.outpatient.dao")
public class OutPatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(OutPatientApplication.class,args);
    }
}
