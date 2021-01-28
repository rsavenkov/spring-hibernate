package ru.easyum.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.easyum.spring.di.Course;
import ru.easyum.spring.di.Teacher;

import java.util.ArrayList;
import java.util.List;

@Scope("prototype")
@Service("teacher")
public class TeacherService {

    @Autowired
    private TeacherRespository respository;

    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(respository.getTeacher());
        return teachers;
    }
}
