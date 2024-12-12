package me.hooo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许所有路径的跨域请求
                .allowedOrigins("http://hooo.me", "http://localhost:3000", "https://hooo.me", "http://8.141.119.241")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的HTTP方法
                .allowedHeaders("*") // 允许的HTTP头部
                .allowCredentials(true) // 允许携带凭证（如Cookies）
                .maxAge(3600); // 预检请求的缓存时间（秒）
    }
}