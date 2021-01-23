package ru.easyum.spring.scope;

public class SingletonBean {

    @Override
    public String toString() {
        return "singleton " + hashCode();
    }
}
