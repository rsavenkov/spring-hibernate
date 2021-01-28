package ru.easyum.spring.di;

import org.springframework.beans.factory.annotation.Required;

public class Student {

    private Course course;
    private String fio;

    public Student() {}

    public Student(Course course, String fio) {
        this.course = course;
        this.fio = fio;
    }

    @Required
    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return String.format("Студент %s на курсе %s", fio, course);
    }

}
