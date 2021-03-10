package ru.avenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.avenue.domains.Authority;
import ru.avenue.domains.User;
import ru.avenue.repository.AuthorityRepository;
import ru.avenue.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private AuthorityRepository authorityRepository;

    public User findUser(long id) {
        return repository.findById(id).get();
    }

    public List<User> findAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Transactional
    public void saveUser(User user, Authority authority) {
        repository.save(user);
        authorityRepository.save(authority);
    }

    public User findUserByUserName(String userName) {
        return repository.findByUsername(userName);
    }

    public List<User> getPage(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<User> coursePage = repository.findAll(paging);
        if (coursePage.hasContent()) {
            return coursePage.getContent();
        } else {
            return new ArrayList<>();
        }
    }

}
