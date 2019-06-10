package com.mateacademy.controller;

import com.mateacademy.model.User;
import com.mateacademy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ApplicationController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User user, ModelAndView modelAndView) {
        modelAndView.setViewName("loginPost");
        modelAndView.addObject("check", userService.findUserByEmail(user));
        return modelAndView;
    }

}
