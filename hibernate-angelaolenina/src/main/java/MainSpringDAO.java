import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.avenue.domains.Teacher;
import ru.avenue.service.CourseService;
import ru.avenue.service.TeacherService;

import java.util.List;

public class MainSpringDAO {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        CourseService service = context.getBean(CourseService.class);
        System.out.println(service.findAllCourses());

        TeacherService service1 = context.getBean(TeacherService.class);
        service1.saveTeacher(new Teacher("Николай Николаев", "Учитель веб программирования", null));
        System.out.println(service1.findAllTeachers());

        List<Teacher> teacherList = service1.findTeachersByFio("Николай Николаев");
        System.out.println(teacherList.get(0).getFio());

        teacherList = service1.findByAbout("+");
        System.out.println(teacherList.get(0).getFio());

    }
}
