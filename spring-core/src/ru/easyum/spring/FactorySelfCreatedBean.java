package ru.easyum.spring;

public class FactorySelfCreatedBean {

    private static FactorySelfCreatedBean bean = new FactorySelfCreatedBean();

    private FactorySelfCreatedBean() {
    }

    public static FactorySelfCreatedBean createInstance() {
        return bean;
    }

    @Override
    public String toString() {
        return "FactorySelfCreatedBean!";
    }

}