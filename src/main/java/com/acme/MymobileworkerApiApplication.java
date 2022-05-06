package com.acme;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MymobileworkerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymobileworkerApiApplication.class, args);
    }


    @Bean
    public ModelMapper getModeMapper(){
        return new ModelMapper();
    }
}
