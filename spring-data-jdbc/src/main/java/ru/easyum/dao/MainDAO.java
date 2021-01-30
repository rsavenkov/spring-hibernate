package ru.easyum.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDAO {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        JdbcCommonDAO dao = context.getBean(JdbcCommonDAO.class);

        dao.insertCourse(1, "Spring+hibernate", 32);
        System.out.println(dao.getCourses());
    }
}
