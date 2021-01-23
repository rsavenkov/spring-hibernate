package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLazy {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-lazy.xml");
        System.out.println("After context initialization!");
        context.getBean("lazy");
    }
}
