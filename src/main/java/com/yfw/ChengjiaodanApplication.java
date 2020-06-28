package com.yfw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.yfw.chengjiaodan.mapper"})
public class ChengjiaodanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChengjiaodanApplication.class, args);
    }

}
