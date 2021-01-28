package ru.easyum.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.spring.FactorySelfCreatedBean;
import ru.easyum.spring.HelloWorld;
import ru.easyum.spring.di.Course;
import ru.easyum.spring.di.Student;
import ru.easyum.spring.di.Teacher;

public class MainRequired {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config-annotation.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean("teacher", Teacher.class);
        System.out.println(teacher);

        Course java = context.getBean("course-java", Course.class);
        System.out.println(java + " " + Course.cache);
        Course python = context.getBean("course-python", Course.class);
        System.out.println(python + " " + Course.cache);
    }
}