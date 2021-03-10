package ru.avenue.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.avenue.MyUserPrincipal;
import ru.avenue.domains.Authority;
import ru.avenue.domains.User;
import ru.avenue.repository.UserRepository;
import ru.avenue.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService service;
    @Autowired
    UserRepository repository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String allUsers(@RequestParam(defaultValue = "0") Integer pageNo,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             Model model) {
        if (logger.isInfoEnabled()) {
            logger.info("Page number = " + pageNo + " page size = " + pageSize);
        }
        Long total = repository.count();
        List<User> users = service.getPage(pageNo, pageSize);
        model.addAttribute("users", users);
        MyUserPrincipal principal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal.getUsername());
        model.addAttribute("pages", new Integer[(int) Math.ceil((double) total / 5)]);
        return "users";
    }

    @GetMapping(path ="/user/add")
    public String addUser(Model model) {
        return "userAdd";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(path = "/user/save")
    public String saveUser(@RequestParam String login, @RequestParam String password,
                           @RequestParam String confirmPassword, @RequestParam String role,
                           @RequestParam Boolean enabled) {
        if (!password.equals(confirmPassword)) {
            return "redirect:/user/add?confirmedError=true";
        }
        Authority authority = new Authority();
        authority.setAuthority(role);
        authority.setUsername(login);
        User user = new User();
        user.setUsername(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(enabled);
        service.saveUser(user, authority);
        return "redirect:/users";
    }

}
