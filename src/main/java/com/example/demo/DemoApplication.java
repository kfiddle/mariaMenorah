package com.example.demo;

import com.example.demo.models.FoundationItem;
import com.example.demo.models.Purpose;
import com.example.demo.repositories.PurposeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
