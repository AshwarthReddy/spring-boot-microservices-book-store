package com.anr.booklistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BookListServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookListServiceApplication.class, args);
    }
}
