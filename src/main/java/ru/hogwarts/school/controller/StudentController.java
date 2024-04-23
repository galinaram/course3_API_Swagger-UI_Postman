package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable long id){
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(Student student){
        return studentService.createStudent(student);
    }
}
