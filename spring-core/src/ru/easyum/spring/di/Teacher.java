package ru.easyum.spring.di;

public class Teacher {

    private Course course;
    private Student student;

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString() {
        return String.format("Учитель ведет %s курса %s студентам", course, student);
    }
}
