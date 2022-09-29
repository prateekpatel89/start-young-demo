package com.snipers.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AzureApplication {
    public static void main(String[] args) {
        SpringApplication.run(AzureApplication.class, args);
    }
}
