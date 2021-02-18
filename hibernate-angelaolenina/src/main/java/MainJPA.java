import ru.avenue.domains.Course;
import ru.avenue.domains.Student;
import ru.avenue.domains.Teacher;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MainJPA {

    //TODO better move factory code to singleton

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myPersistentDB");
        EntityManager entityManager = factory.createEntityManager();

        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();

            /*Course junior = new Course("Java junior", 64);
            Course middle = new Course("Java middle", 85);

            List<Course> courses = new ArrayList<Course>();
            courses.add(junior);
            courses.add(middle);

            Teacher teacher = new Teacher("Петр Петрович", "Учитель программирования", courses);
            junior.setTeacher(teacher);
            middle.setTeacher(teacher);

            entityManager.persist(teacher);*/

            //------------------------------------------------------------------

            /*Teacher teacher = entityManager.find(Teacher.class, 1);
            System.out.println(teacher.getCourses());*/

            //------------------------------------------------------------------

            /*for (int i = 0; i < 10; i++) {
                Course course = new Course("Course-" + i, i*10);
                entityManager.persist(course);

            }*/

            //------------------------------------------------------------------

            /*for (int i = 0; i < 10; i++) {
                if (i > 0 && i % 5 == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
                Course course = new Course("Course-" + i, i*10);
                entityManager.persist(course);
            }*/

            //------------------------------------------------------------------

            /*String hql = "FROM Teacher";
            Query query = entityManager.createQuery(hql);
            System.out.println(query.getResultList());

            hql = "SELECT c.name FROM Course c WHERE c.duration = 64";
            query = entityManager.createQuery(hql);
            System.out.println(query.getResultList());

            hql = "select SUM(duration), c.teacher from Course c where c.teacher.fio = :fio group by c.teacher";
            query = entityManager.createQuery(hql);
            query.setParameter("fio", "Петр Петрович");
            System.out.println(query.getResultList());*/

            //------------------------------------------------------------------

            /*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Student> cr = cb.createQuery(Student.class);
            Root<Student> root = cr.from(Student.class);

            cr.select(root);
            List<Student> result = entityManager.createQuery(cr).getResultList();
            System.out.println(result);

            cr.select(root).where(cb.equal(root.get("fio"), "Иван Иванов"));
            result = entityManager.createQuery(cr).getResultList();
            System.out.println(result);*/

            //------------------------------------------------------------------

            String sql = "SELECT about FROM teacher WHERE fio = :fio";
            List teachers = entityManager.createNativeQuery(sql).setParameter("fio", "Петр Петрович").getResultList();
            System.out.println(teachers);

            sql = "UPDATE teacher SET about = :about WHERE fio = :fio";
            entityManager.createNativeQuery(sql)
                    .setParameter("about", "Учитель программирования+")
                    .setParameter("fio", "Петр Петрович")
                    .executeUpdate();

            //------------------------------------------------------------------

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
