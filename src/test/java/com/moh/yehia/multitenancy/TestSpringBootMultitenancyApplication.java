package com.moh.yehia.multitenancy;

import org.springframework.boot.SpringApplication;

public class TestSpringBootMultitenancyApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringBootMultitenancyApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
