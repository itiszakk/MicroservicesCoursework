package org.spbstu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SeizureInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeizureInfoApplication.class, args);
    }
}