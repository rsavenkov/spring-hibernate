package ru.avenue.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.avenue.HibernateSessionSingleton;
import ru.avenue.domains.Course;
import ru.avenue.domains.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public Student findById(int id) {
        return HibernateSessionSingleton.getSessionFactory().openSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        return HibernateSessionSingleton.getSessionFactory().openSession().createQuery("FROM Student").list();
    }

    public void save(Student student) {

        em.persist(student);

        /*Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();*/
    }
}
