package ru.easyum.spring.di;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private int duration;
    public static List<Course> cache = new ArrayList<>();

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @PostConstruct
    public void cacheCourses() {
        cache.add(this);
    }

    @PostConstruct
    public void doSomething() {
        //TODD do something on destroy...
    }

    @Override
    public String toString() {
        return String.format("Курс %s продолжительностью %s", name, duration);
    }

}
