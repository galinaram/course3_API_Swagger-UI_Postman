package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("{id}")
    public Faculty getFacultyInfo(@PathVariable long id){
        return facultyService.findFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
}
