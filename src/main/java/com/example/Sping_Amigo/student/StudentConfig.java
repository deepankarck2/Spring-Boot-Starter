package com.example.Sping_Amigo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(1L, "Mariam", "ddddddddd@dsl", LocalDate.of(2020, Month.FEBRUARY, 5));
            Student alex = new Student("Alex", "df@dsl", LocalDate.of(1999, Month.FEBRUARY, 5));

            repository.saveAll( //Hibernate runs and saves the vals
                    List.of(mariam, alex)
            );
        };
    }
}
