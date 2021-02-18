package ru.avenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avenue.dao.CourseDAO;
import ru.avenue.domains.Course;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDAO dao;

    public Course findCourse(int id) {
        return dao.findById(id);
    }

    public List<Course> findAllCourses() {
        return dao.findAll();
    }

    public void saveCourse(Course course) {
        dao.save(course);
    }
}
