package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.yfw.chengjiaodan.mapper"})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ChengjiaodanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChengjiaodanApplication.class, args);
    }

}
