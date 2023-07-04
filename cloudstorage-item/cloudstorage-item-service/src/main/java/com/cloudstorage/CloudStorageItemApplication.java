package com.cloudstorage;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wegop
 * @date 2023/7/4 3:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.cloudstorage.item.mapper")
public class CloudStorageItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStorageItemApplication.class,args);
    }
}
