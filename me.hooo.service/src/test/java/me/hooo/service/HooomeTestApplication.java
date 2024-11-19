package me.hooo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"me.hooo.*"})
@SpringBootApplication
public class HooomeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooomeTestApplication.class, args);
    }

}