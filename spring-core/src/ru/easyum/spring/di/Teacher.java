package ru.easyum.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Teacher {

    @Autowired
    @Qualifier("course-java")
    private Course course;
    private Student student;

    public void setCourse(Course course) {
        this.course = course;
    }

    @Autowired
    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString() {
        return String.format("Учитель ведет %s курса %s студентам", course, student);
    }
}
