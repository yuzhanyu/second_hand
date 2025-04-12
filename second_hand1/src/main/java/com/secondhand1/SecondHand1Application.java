package com.secondhand1;

import java.lang.Boolean;
import java.lang.String;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 项目启动类
 *
 * @author LENOVO
 * @date 2025-03-14 17:06:20
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.secondhand1.dao")
@ImportResource(locations = "classpath:datasource-config.xml")
public class SecondHand1Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SecondHand1Application.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);
    }
}
