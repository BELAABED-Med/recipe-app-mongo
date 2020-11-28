package com.beles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Spring5RecipeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5RecipeAppApplication.class, args);
    }

}
