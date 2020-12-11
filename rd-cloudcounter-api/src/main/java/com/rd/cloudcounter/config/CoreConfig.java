package com.rd.cloudcounter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域实现前后台联调
 * @author
 * @create 2020-12-02-15:09
 */
@Configuration
public class CoreConfig {
    public CoreConfig() {
    }

    @Bean
    public CorsFilter corsFilter(){
        //1.添加core配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");

        //设置是否发送Cookie信息
        config.setAllowCredentials(true);

        //设置允许的请求方式
        config.addAllowedMethod("*");

        //设置允许的header
        config.addAllowedHeader("*");

        //2.为url添加映射路径
        UrlBasedCorsConfigurationSource coreSource = new UrlBasedCorsConfigurationSource();
        coreSource.registerCorsConfiguration("/**",config);

        //3.返回重新定义好的coreSource
        return  new CorsFilter(coreSource);

    }
}
