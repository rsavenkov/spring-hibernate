package ru.avenue.hibernate.dao;

import org.springframework.stereotype.Repository;
import ru.avenue.hibernate.domains.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAll() {
        return em.createQuery("FROM Student ").getResultList();
    }

    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

}
