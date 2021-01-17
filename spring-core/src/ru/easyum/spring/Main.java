package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorldBean = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorldBean);
    }
}