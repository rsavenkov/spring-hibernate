import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.avenue.domains.Course;
import ru.avenue.domains.Student;
import ru.avenue.domains.Teacher;
import ru.avenue.service.ModuleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTransactional {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ModuleService service = context.getBean(ModuleService.class);

        Course junior = new Course("Java junior", 32);
        List<Course> courses = new ArrayList<>();
        courses.add(junior);

        Student student = new Student("Сидр Сидорович", new Date(), 1000L, courses);
        junior.setStudent(student);
        List<Student> students = new ArrayList<>();
        students.add(student);

        Teacher teacher = new Teacher("Учитель", "Учитель", courses);

        service.createModule(teacher, junior, students);
    }
}
