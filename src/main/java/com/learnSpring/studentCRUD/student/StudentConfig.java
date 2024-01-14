package com.learnSpring.studentCRUD.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner( StudentRepository repository){
        return args -> {
            Student vegeta = new Student(
                    "Vegeta",
                    "vegeta@gmail.com",
                            LocalDate.of(2000, DECEMBER,2)
            );
            Student goku = new Student(
                    "Goku",
                    "goku@gmail.com",
                    LocalDate.of(1998, FEBRUARY,14)
            );
            repository.saveAll(
                    List.of(vegeta,goku)
            );
        };
    }
}
