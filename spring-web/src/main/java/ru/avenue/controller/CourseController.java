package ru.avenue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.avenue.MyUserPrincipal;
import ru.avenue.domains.Course;
import ru.avenue.domains.Teacher;
import ru.avenue.repository.CourseRepository;
import ru.avenue.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CourseController {

    @Autowired
    CourseService service;
    @Autowired
    CourseRepository repository;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String allCourses(@RequestParam(defaultValue = "0") Integer pageNo,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             Model model) {
        Long total = repository.count();
        List<Course> courses = service.getPage(pageNo, pageSize);
        model.addAttribute("courses", courses);
        MyUserPrincipal principal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal.getUsername());
        model.addAttribute("pages", new Integer[(int) Math.ceil((double) total / 5)]);
        return "courses";
    }

    @RequestMapping(path = "/courses/{courseName}")
    public String getCourseTeachers(@PathVariable String courseName, Model model) {
        List<Teacher> teachers = service.getTeachersByCourseName(courseName);
        model.addAttribute("teachers", teachers.size());
        return "/jsp/teachers";
    }

    @RequestMapping(path = "/course/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCourse(@RequestBody Course course) {
        service.saveCourse(course);
    }

    @RequestMapping("/course/get")
    public String findCourse(@RequestParam("courseId") int courseId, Model model) {
        Course course = service.findCourse(courseId);
        model.addAttribute("course", course);
        return "/jsp/course";
    }

    @GetMapping(value = "/coursesAll")
    @ResponseBody
    public String allCourses() {
        return "Course list: " + service.findAllCourses().stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", ", "", ""));
    }

    @GetMapping("/setCookie")
    public String setCourseCookie(@CookieValue("JSESSIONID") String cookie,
                                  @RequestHeader("Accept-Encoding") String encoding) {
        System.out.println("Cookie mycookie -> " + cookie);
        System.out.println("header accept encoding -> " + encoding);
        return "/jsp/hello";
    }

    @GetMapping("/create")
    public String create() {
        return "/jsp/create";
    }

    @PostMapping("/course/save1")
    public String save(@RequestParam String name, @RequestParam int duration) {
        Course course = service.saveCourse(new Course(name, duration));
        return "redirect:/course/get?courseId=" + course.getId();
    }

    @GetMapping(path ="/course/add")
    public String addCourse(Model model) {
        return "courseAdd";
    }

    @PreAuthorize("#username == authentication.principal.username")
//    @Secured({"ROLE_ADMIN", "ROLE_SUPER_ADMIN"})
    @PostMapping(path = "/course/save")
    public String saveCourse(@RequestParam String name, @RequestParam int duration) {
        service.saveCourse(new Course(name, duration));
        return "redirect:/courses";
    }

}
