package com.rdutta.directoryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DirectoryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DirectoryServerApplication.class, args);
    }
}
