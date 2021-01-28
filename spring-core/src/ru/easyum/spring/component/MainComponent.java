package ru.easyum.spring.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainComponent {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config-component.xml");
        CourseService service = context.getBean(CourseService.class);
        System.out.println(service.getActiveTeacher());

        SchoolService schoolService = context.getBean(SchoolService.class);
        System.out.println(schoolService.getJavaCourse());
        System.out.println(schoolService.getPythonCourse());

        TeacherService teacherService = (TeacherService) context.getBean("teacher");
        System.out.println(teacherService.getTeachers());
    }
}
