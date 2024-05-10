package com.hitices.basicenvreport.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix = "envreport")
@Getter
@Setter
public class LocalConfig {
    private String position;
    private String CloudUrl;
}
