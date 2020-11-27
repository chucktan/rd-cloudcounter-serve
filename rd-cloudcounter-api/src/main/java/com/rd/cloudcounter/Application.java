package com.rd.cloudcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author
 * @create 2020-11-23-14:10
 */
@SpringBootApplication
//扫描mybatis通用mapper所在的包
@MapperScan(basePackages = "com.rd.cloudcounter.mapper")
//扫描所有的包以及相关的组件
@ComponentScan(basePackages = {"com.rd.cloudcounter","org.n3r.idworker"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
