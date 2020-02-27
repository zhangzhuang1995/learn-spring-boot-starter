package com.forezp.learnspringbootstarter;

import com.forezp.learnspringbootstarter.httpstarter.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * starter自动注册原理
 */
@SpringBootApplication
public class SpringBootStarterApplication implements CommandLineRunner {

    @Autowired
    private HttpClient httpClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(httpClient.getUrl());
    }
}
