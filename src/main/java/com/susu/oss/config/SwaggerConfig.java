package com.susu.oss.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

// http://localhost:8001/doc.html#/home
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment e){

        Profiles profiles = Profiles.of("dev","test");
        boolean flag = e.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("webApi")
                .enable(flag)
                .select()
                // 指定扫描该包下的接口
                // .apis(RequestHandlerSelectors.any())  扫描所有
                // none() 不扫描
                // .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapper.Class)) 扫描方法上的注解
                // .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) 扫描类上的注解
                // .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                // 如果接口路径中包含admin/error则不进行显示
                /*.paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))*/
                // 过滤路径
                // .paths(PathSelectors.ant("/example/**"))
                .build();

    }

    private ApiInfo apiInfo(){

        // 作者信息
        Contact contact = new Contact(
                "Sujay",
                "http://localhost:8001/doc.html#/home",
                "fxbsujay@gmail.com");
        return new ApiInfo(
                "SUSU-OSS API文档",
                "Api Documentation",
                "1.0.0",
                "localhost:8001/服务名/模块名",
                // DEFAULT_CONTACT,
                contact,
                "MIT License",
                "https://github.com/fxbsujay/Sujay-OSS/blob/main/LICENSE",
                new ArrayList<>());

    }
}
