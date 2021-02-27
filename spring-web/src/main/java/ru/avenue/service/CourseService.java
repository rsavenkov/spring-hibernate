package ru.avenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.avenue.dao.CourseDAO;
import ru.avenue.domains.Course;
import ru.avenue.domains.Teacher;
import ru.avenue.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseDAO dao;

    @Autowired
    private CourseRepository repository;

    public Course findCourse(int id) {
        return dao.findById(id);
    }

    public List<Course> findAllCourses() {
        return dao.findAll();
    }

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public List<Teacher> getTeachersByCourseName(String courseName) {
        List<Course> courses = repository.findByName(courseName);
        return courses.stream().map((c) -> c.getTeacher()).collect(Collectors.toList());
    }

    public List<Course> getPage(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Course> coursePage = repository.findAll(paging);
        if (coursePage.hasContent()) {
            return coursePage.getContent();
        } else {
            return new ArrayList<>();
        }
    }

}
