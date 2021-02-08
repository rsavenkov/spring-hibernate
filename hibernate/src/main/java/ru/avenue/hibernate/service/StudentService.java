package ru.avenue.hibernate.service;

import ru.avenue.hibernate.dao.StudentDAO;
import ru.avenue.hibernate.domains.Student;

import java.util.List;

public class StudentService {

    private StudentDAO dao = new StudentDAO();

    public Student findStudent(int id) {
        return dao.findById(id);
    }

    public List<Student> findAllStudents() {
        return dao.findAll();
    }

    public void saveStudent(Student student) {
        dao.save(student);
    }
}
