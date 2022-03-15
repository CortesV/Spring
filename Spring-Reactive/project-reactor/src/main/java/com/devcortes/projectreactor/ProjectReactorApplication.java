package com.devcortes.projectreactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ProjectReactorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectReactorApplication.class, args);

    }

}
