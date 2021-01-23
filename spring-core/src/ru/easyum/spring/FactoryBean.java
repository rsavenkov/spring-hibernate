package ru.easyum.spring;

public class FactoryBean {

    private static HelloWorld helloWorldBean = new HelloWorld();

    private FactoryBean() {
    }

    public HelloWorld createHelloWorldInstance() {
        return helloWorldBean;
    }

}
