package ru.avenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.avenue.dao.CourseDAO;
import ru.avenue.dao.StudentDAO;
import ru.avenue.domains.Course;
import ru.avenue.domains.Student;
import ru.avenue.domains.Teacher;
import ru.avenue.repository.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public void createModule(Teacher teacher, Course course, List<Student> students) {
        teacherRepository.save(teacher);
        courseDAO.save(course);
        for (Student student : students) {
            studentDAO.save(student);
        }
    }

}
