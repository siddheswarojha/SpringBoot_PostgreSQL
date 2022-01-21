package com.sid.springmvc.Services;

import com.sid.springmvc.Model.Student;
import com.sid.springmvc.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentServices {




    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }

    public List<Student> getStudent()
    {

        return studentRepository.findAll();


//        return List.of(new Student(
//                1L,
//                "Sid",
//                "sid@gmail.com",
//                LocalDate.of(2000, Month.AUGUST,31),
//                22
//        ));
    }
}