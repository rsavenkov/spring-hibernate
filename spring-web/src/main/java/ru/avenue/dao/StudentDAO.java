package ru.avenue.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.avenue.domains.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAll() {
        return em.createQuery("FROM Student").getResultList();
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
