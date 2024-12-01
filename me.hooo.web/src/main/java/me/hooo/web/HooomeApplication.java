package me.hooo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"me.hooo.*"})
@SpringBootApplication
public class HooomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooomeApplication.class, args);
    }

}