package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;
@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        return facultyMap.put(lastId, faculty);
    }
    public Faculty findFaculty(long id){
        if (facultyMap.containsKey(id)) {
            return facultyMap.get(id);
        }
        return null;
    }
    public Faculty editFaculty(Faculty faculty){
        if (facultyMap.containsKey(faculty.getId())) {
            return facultyMap.put(faculty.getId(), faculty);
        }
        return null;
    }
    public Faculty deleteFaculty(long id){
        if (facultyMap.containsKey(id)) {
            return facultyMap.remove(id);
        }
        return null;
    }
}
