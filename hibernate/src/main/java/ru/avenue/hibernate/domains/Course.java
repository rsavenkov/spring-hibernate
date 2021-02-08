package ru.avenue.hibernate.domains;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private Integer duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public Course() {
    }

    public Course(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
