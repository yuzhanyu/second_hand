package com.secondhand1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author hanghang
 * @date 2025/3/18
 * @Description
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("二手商品交易平台 API")
                        .version("1.0")
                        .description("二手商品交易平台的API文档"));
    }
}