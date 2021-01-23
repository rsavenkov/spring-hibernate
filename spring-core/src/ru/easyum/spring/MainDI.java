package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.spring.di.Student;
import ru.easyum.spring.di.Teacher;

public class MainDI {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-di.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }
}
