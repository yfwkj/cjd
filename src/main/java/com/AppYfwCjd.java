package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: AppYfwCjd
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 8:43
 * @Version: 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.mapper"})
public class AppYfwCjd {
    public static void main(String[] args) {
           SpringApplication.run(AppYfwCjd.class,args);
    }
}
