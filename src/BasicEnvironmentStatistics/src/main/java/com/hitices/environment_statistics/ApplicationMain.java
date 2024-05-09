package com.hitices.environment_statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

/**
 * @author ferdinandsu
 * @date 2021/8/18
 **/

@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
