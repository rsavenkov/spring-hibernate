package ru.easyum.spring.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class School {

    Properties contacts;

    List<Course> courses;

    Set<Teacher> teachers;

    Map<Integer, Student> students;

    public void setContacts(Properties contacts) {
        this.contacts = contacts;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("It школа %s предлагает учащимся %s курсов.", contacts.get("name"), courses.size());
    }
}
