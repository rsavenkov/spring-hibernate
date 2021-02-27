package ru.avenue.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.avenue.domains.Course;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {

    List<Course> findByName(String name);

}
