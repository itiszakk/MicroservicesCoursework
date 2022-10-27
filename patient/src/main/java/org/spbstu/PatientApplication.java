package org.spbstu;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class PatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Bean
    @LoadBalanced
    @Profile("!k8s")
    @Qualifier("restTemplate")
    public RestTemplate defaultRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Profile("k8s")
    @Qualifier("restTemplate")
    public RestTemplate k8sRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}