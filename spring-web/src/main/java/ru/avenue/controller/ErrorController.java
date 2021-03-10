package ru.avenue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @GetMapping(value = "errors")
    public ModelAndView errorPage(HttpServletRequest request) {
        ModelAndView errorPage = new ModelAndView("error");
        String errorMsg = "";
        int httpErrorCode = (int) request.getAttribute("javax.servlet.error.status_code");
        switch (httpErrorCode) {
            case 403:
                errorMsg = "У вас нет доступа в этот раздел сайта";
                break;
            case 404:
                errorMsg = "Страница не найдена";
                break;
            case 500:
                errorMsg = "Ошибка на сервере! Обратитесь к администратору.";
                break;
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }
}
