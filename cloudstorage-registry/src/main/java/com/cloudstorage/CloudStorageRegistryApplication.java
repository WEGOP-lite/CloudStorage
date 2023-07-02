package com.cloudstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wegop
 * @date 2023/7/2 20:02
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudStorageRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStorageRegistryApplication.class,args);
    }
}
