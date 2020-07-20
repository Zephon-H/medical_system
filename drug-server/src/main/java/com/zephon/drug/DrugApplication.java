package com.zephon.drug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.drug
 * @date 2020/7/17 下午2:17
 * @Copyright ©
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.zephon.drug.dao")
public class DrugApplication {
    public static void main(String[] args) {
        SpringApplication.run(DrugApplication.class,args);
    }
}
