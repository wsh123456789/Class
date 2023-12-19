package com.example.purchase.util;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 86151 on 2019/8/26.
 */
@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix = "hr", name = "swagger-open", havingValue = "true")
public class Swagger3 {
    @Bean
    public Docket createRestApi() {
     /*   return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))   //这里采用包含注解的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.fz.hr.modules.system.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }*/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //不显示错误接口地址以及监控接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*|/actuator.*"))).build()
                .groupName("cloud-teacher-api")
                .apiInfo(apiInfo())
                /*.forCodeGeneration(true)*/;
    }

   private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HR Doc")
                .description("HR Api文档")
                .contact("WH")
                .version("2.0")
                .build();
    }
    //http://localhost:18082/swagger-ui.html
}
