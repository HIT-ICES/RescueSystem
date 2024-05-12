package com.hitices.patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/9/21
 */

@SpringBootApplication
@EnableFeignClients
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
