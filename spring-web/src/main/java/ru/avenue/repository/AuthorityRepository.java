package ru.avenue.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.avenue.domains.Authority;
import ru.avenue.domains.Course;

import java.util.List;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Integer> {

    List<Authority> findByUsername(String username);

}
