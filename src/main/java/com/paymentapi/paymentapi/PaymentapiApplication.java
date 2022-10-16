package com.paymentapi.paymentapi;

import com.paymentapi.paymentapi.mappers.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaAuditing
public class PaymentapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentapiApplication.class, args);
    }
}