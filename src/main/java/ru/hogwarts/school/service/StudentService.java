package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student){
        student.setId(++lastId);
        studentMap.put(lastId, student);
        return student;
    }
    public Student findStudent(long id){
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        }
        return null;
    }
    public Student editStudent(Student student){
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }
    public Student deleteStudent(long id){
        return studentMap.remove(id);
    }
}
