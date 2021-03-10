package ru.avenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.avenue.MyUserPrincipal;
import ru.avenue.domains.Authority;
import ru.avenue.domains.User;
import ru.avenue.repository.AuthorityRepository;
import ru.avenue.repository.UserRepository;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<Authority> authorities = authorityRepository.findByUsername(user.getUsername());
        return new MyUserPrincipal(user, authorities);
    }
}
