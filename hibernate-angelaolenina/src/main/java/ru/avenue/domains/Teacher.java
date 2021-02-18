package ru.avenue.domains;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fio")
    private String fio;
    @Column(name = "about")
    private String about;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(String fio, String about, List<Course> courses) {
        this.fio = fio;
        this.about = about;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getFio() {
        return fio;
    }
}
