package com.sid.springmvc.Controller;


import com.sid.springmvc.Model.Student;
import com.sid.springmvc.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class MYController {

    @Autowired
    private StudentServices studentServices;

//    public MYController(StudentServices studentServices) {
//        this.studentServices = studentServices;
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/getstudentdata")

    @GetMapping("/getstudentdata")
    public List<Student> getStudent() {
        return studentServices.getStudent();
    }


}
