import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.avenue.hibernate.HibernateSessionSingleton;
import ru.avenue.hibernate.domains.Course;
import ru.avenue.hibernate.domains.Student;
import ru.avenue.hibernate.service.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(final String[] args) {

        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Course junior = new Course("Java junior", 64);
        Course middle = new Course("Java middle", 85);

        List<Course> courses = new ArrayList();
        courses.add(junior);
        courses.add(middle);

        Student student = new Student("John", new Date(123456), 1000L, courses);
        junior.setStudent(student);
        middle.setStudent(student);

        StudentService studentService = new StudentService();
        studentService.saveStudent(student);

        tx.commit();
        session.close();
    }
}