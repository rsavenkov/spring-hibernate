package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.spring.di.School;

public class MainCollectionRef {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-collection.xml");
        School school = context.getBean("school", School.class);
        System.out.println(school);
    }
}
