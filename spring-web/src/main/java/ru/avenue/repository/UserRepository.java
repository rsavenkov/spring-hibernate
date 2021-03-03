package ru.avenue.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.avenue.domains.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

}
