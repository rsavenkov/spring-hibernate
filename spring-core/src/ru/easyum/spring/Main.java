package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/xml/spring-config.xml");
        HelloWorld helloWorldBean = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorldBean);

        FactorySelfCreatedBean factorySelfCreatedBean = (FactorySelfCreatedBean) context.getBean("FactorySelfCreatedBean");
        System.out.println(factorySelfCreatedBean);

        HelloWorld helloWorld = context.getBean("helloWorldFromFactory", HelloWorld.class);
        System.out.println(helloWorld);
    }
}