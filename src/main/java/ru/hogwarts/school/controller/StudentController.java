package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.text.CollationKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id){
        Student student = studentService.findStudent(id);
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student editedStudent = studentService.editStudent(student);
        if (editedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping
    public Collection<Student> getStudentsWithOneAge(@RequestParam int age){
        List<Student> studentsCollection = new ArrayList<>();
        int i = 0;
        while (studentService.findStudent(i)!= null){
            if(studentService.findStudent(i).getAge() == age){
                studentsCollection.add(studentService.findStudent(i));
                i++;
            }
        }
        return studentsCollection;
    }
}
