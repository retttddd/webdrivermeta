package com.ivan.webdrivermeta;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@PropertySource("classpath:application.properties")
public class WebdrivermetaApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebdrivermetaApplication.class, args);

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            int minPort = 8080;
            int maxPort = 65535;
            int randomPort = new Random().nextInt(maxPort - minPort + 1) + minPort;

            factory.setPort(randomPort);
        };
    }

}
