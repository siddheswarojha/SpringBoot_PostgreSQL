package com.sid.springmvc.Controller;


import com.sid.springmvc.Model.Student;
import com.sid.springmvc.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody  Student student)
    {
       studentServices.addStudent(student);
    }

    @DeleteMapping(path = "/deleteStudent/{studentId}")
    public  void deleteStudent(@PathVariable("studentId") Long studentId)
    {

        studentServices.deleteStudent(studentId);
    }

    @PutMapping (path = "/updateStudent/{studentId}")

    public  void updateStudent(@PathVariable("studentId") Long studentId,
                               @RequestParam(required = false)String name,
                                @RequestParam(required = false)String email)
    {
        studentServices.updateStudent(studentId,name,email);
    }





}
