package com.gen.com.Insurance_portal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class InsurancePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsurancePortalApplication.class, args);
    }

}
