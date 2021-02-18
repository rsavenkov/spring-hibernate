package ru.avenue.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.avenue.domains.Teacher;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    List<Teacher> findAllByFio(String fio);

    @Query("SELECT t FROM Teacher t WHERE t.about LIKE %?1%")
    List<Teacher> findByAboutPartialMatch(String about);
}
