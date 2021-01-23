package ru.easyum.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyum.spring.lifecycle.LifecycleBean;

public class MainLifeCycle {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config-lifecycle.xml");
        LifecycleBean bean = context.getBean("secret", LifecycleBean.class);
        System.out.println("Secret is " + bean.showMeSecret());
        context.registerShutdownHook();
    }
}
