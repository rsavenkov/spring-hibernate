package ru.easyum.spring.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.easyum.spring.di.Course;
import ru.easyum.spring.di.Student;

@Configuration
public class ApplicationConfig {

    @Bean
    public ApplicationConfig myConfig() {
        return new ApplicationConfig();
    }

    @Bean("student")
    public Student student(Course course) {
        return new Student(course, "Иван Иванов");
    }

    @Bean("course")
    public Course course() {
        return new Course("Java junior", 16);
    }

    @Override
    public String toString() {
        return "Java-based application configuration!";
    }
}
