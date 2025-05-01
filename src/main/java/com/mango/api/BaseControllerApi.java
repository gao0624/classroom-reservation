package com.mango.api;


import com.mango.pojo.Student;
import com.mango.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseControllerApi {

    @Autowired
    private StudentServiceImpl studentService;
    @GetMapping("/api/students")
    public List<Student> getStudents() {
        return studentService.getAll();
    }
}
