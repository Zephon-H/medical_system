package com.zephon.doctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor
 * @date 2020/7/13 下午4:59
 * @Copyright ©
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.zephon.doctor.dao")
@EnableFeignClients
public class DoctorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoctorApplication.class,args);
    }
}
