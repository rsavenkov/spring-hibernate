package ru.avenue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello from controller method!");
        return "/jsp/hello";
    }
}
