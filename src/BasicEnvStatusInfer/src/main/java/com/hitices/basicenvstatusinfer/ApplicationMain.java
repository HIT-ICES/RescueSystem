package com.hitices.basicenvstatusinfer;


import com.hitices.basicenvstatusinfer.ann.MainClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        String[] strings = {"-train","data/train.txt"};
        MainClass.start(strings);
        SpringApplication.run(ApplicationMain.class,args);
    }
}
