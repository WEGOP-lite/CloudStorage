package com.cloudstorage.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author wegop
 * @date 2023/9/22 16:29
 */
@Configuration
public class CloudStorageCorsFilterConfiguration {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许的域名 不要写* 否则无法使用cookie
        corsConfiguration.addAllowedOrigin("http://manage.cloudstorage.com");
        // 是否发送cookie信息
        corsConfiguration.setAllowCredentials(true);
        // 允许的请求方式
        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");
        // 允许的头信息
        corsConfiguration.addAllowedHeader("*");
        // 添加映射路径，拦截,第一个参数为拦截路径，第二个参数为cors配置类
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
