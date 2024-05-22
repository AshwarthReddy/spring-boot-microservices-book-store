package com.anr.booklistservice;

import org.springframework.boot.SpringApplication;

public class TestBookListServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(BookListServiceApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
