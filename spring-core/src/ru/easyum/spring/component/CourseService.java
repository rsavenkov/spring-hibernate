package ru.easyum.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.spring.di.Course;
import ru.easyum.spring.di.Teacher;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRespository respository;

    public Teacher getActiveTeacher() {
        List<Course> courses = respository.findAllCourses();
        Teacher teacher = new Teacher();
        teacher.setCourse(courses.get(0));
        return teacher;
    }
}
