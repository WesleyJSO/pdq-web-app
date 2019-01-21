package com.pdq.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EntityScan({"com.pdq", "com.dvsmedeiros"})
@ComponentScan({"com.pdq", "com.dvsmedeiros"})
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
@EnableCaching
public class ServerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(ServerApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/*").allowedOrigins("*");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
}
