package ru.easyum.spring.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.easyum.spring.di.Student;

public class MainJava {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationConfig config = (ApplicationConfig) context.getBean("myConfig");
        System.out.println(config);

        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
