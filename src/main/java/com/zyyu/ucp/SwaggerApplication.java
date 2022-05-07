package com.zyyu.ucp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 创建Swagger配置类
 * 和启动类同级
 */
@Configuration
@EnableSwagger2
public class SwaggerApplication {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)// 指定api类型为swagger2
                .apiInfo(apiInfo())         // // 用于定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ida.wj.controller"))//指定包名
                .paths(PathSelectors.any())//包下面的所有类
                .build();
    }
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("利用swagger2构建的API文档")
                .description("用restful风格写接口")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
