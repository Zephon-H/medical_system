package com.zephon.common.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.common.configure
 * @date 2020/7/12 上午9:56
 * @Copyright ©
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<Parameter>();
//        ticketPar.name("access-token").description("登录校验")//name表示名称，description表示描述
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).defaultValue("").build();//required表示是否必填，defaultvalue表示默认值
//        pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zephon"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Medical System RESTful APIs")
                .description("医疗系统API")
                .version("1.0")
                .build();
    }
}
