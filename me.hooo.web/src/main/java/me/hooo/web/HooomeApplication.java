package me.hooo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"me.hooo"})
public class HooomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooomeApplication.class, args);
    }

}