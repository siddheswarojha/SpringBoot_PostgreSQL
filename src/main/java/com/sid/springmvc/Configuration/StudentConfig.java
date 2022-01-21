package com.sid.springmvc.Configuration;

import com.sid.springmvc.Model.Student;
import com.sid.springmvc.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository)
    {
        return args -> {
            Student sid = new Student(
                "Sid",
                "sid@gmail.com",
                LocalDate.of(2000, Month.AUGUST,31),
                22
        );
            Student abhishek = new Student(
                    "Abhishek",
                    "abhi@gmail.com",
                    LocalDate.of(2000, Month.MAY,2),
                    21
            );

            studentRepository.saveAll(List.of(sid,abhishek));

        };


    }

}
