import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.avenue.HibernateSessionSingleton;
import ru.avenue.domains.Course;
import ru.avenue.domains.Student;
import ru.avenue.service.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Course junior = new Course("Java junior", 64);
        Course middle = new Course("Java middle", 85);

        List<Course> courses = new ArrayList<Course>();
        courses.add(junior);
        courses.add(middle);

        Student student = new Student("Иван Иванов", new Date(), 100L, courses);
        junior.setStudent(student);
        middle.setStudent(student);

        StudentService service = new StudentService();
        service.saveStudent(student);

        tx.commit();
        session.close();
    }
}
