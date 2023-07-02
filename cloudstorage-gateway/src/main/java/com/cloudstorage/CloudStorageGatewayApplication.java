package com.cloudstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wegop
 * @date 2023/7/2 19:53
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloudStorageGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStorageGatewayApplication.class,args);
    }
}
