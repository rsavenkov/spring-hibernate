package ru.easyum.spring.scope;

public class PrototypeBean {

    @Override
    public String toString() {
        return "prototype " + hashCode();
    }
}
