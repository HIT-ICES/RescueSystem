package com.hitices.notifacation_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
}
