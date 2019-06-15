package com.mateacademy.controller;

import com.mateacademy.model.UserEntity;
import com.mateacademy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        modelAndView.addObject("user", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute UserEntity user, ModelAndView modelAndView) {
        modelAndView.setViewName("loginPost");
        modelAndView.addObject("check", userService.findUserByEmail(user));
        return modelAndView;
    }

}
