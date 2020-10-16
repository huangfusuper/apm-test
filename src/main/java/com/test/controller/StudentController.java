package com.test.controller;

import com.test.entity.Student;
import com.test.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangfu
 */
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("findStudent")
    public Student findStudent(Integer id){
        return studentService.findOneStudent(id);
    }
}
