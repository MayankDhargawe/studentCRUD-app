package com.learnSpring.studentCRUD.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//the controller class is responsible for handling HTTP requests, processing business logic, and preparing a response in a Spring Boot application.
// It acts as a bridge between the incoming requests and the application's business logic and views.
@RestController // used to define a class as a RESTful web service controller. In simpler terms, it combines the @Controller and @ResponseBody annotations.
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired //used for automatic dependency injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId,name,email);
    }
}
