package me.hooo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class HooomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooomeApplication.class, args);
    }

}
