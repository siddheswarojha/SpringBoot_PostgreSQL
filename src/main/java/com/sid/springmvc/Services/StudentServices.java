package com.sid.springmvc.Services;

import com.sid.springmvc.Model.Student;
import com.sid.springmvc.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addStudent(Student student)
    {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email is already in use");

        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists)
        {
            throw new IllegalStateException("Id Not found");
        }
        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name,String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException("Student Not Found"));





            if(name!=null && !Objects.equals(student.getName(),name))
            {
                student.setName(name);
            }


        if(email!=null && !Objects.equals(student.getEmail(),name))
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("Email is already in use");
            }
            student.setEmail(email);
        }




    }
}
