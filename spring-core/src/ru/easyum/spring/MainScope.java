package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScope {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-scope.xml");
        for (int i = 0; i < 5; i++) {
            System.out.println(context.getBean("singleton"));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(context.getBean("prototype"));
        }
    }
}
