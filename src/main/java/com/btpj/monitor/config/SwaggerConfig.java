package com.btpj.monitor.config;

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
 * Swagger2配置类
 *
 * @author BTPJ  2020/8/24
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Api接口包扫描路径
    private static final String BASE_PACKAGE = "com.btpj.monitor.controller";

    // 版本号
    private static final String SWAGGER2_API_VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    /**
     * API配置信息
     *
     * @return API配置信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("采棉系统API文档")
                .description("by BTPJ")
                .version(SWAGGER2_API_VERSION)
                .build();
    }
}
