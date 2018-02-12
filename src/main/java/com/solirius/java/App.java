package com.solirius.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("HideUtilityClassConstructor") // Spring needs a constructor, its not a utility class
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
