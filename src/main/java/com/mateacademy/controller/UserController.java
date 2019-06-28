package com.mateacademy.controller;

import com.mateacademy.model.UserEntity;
import com.mateacademy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public ModelAndView addUser(ModelAndView modelAndView) {
        modelAndView.setViewName("registerUser");
        modelAndView.addObject("user", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView addUser(@ModelAttribute UserEntity user, ModelAndView modelAndView) {
        modelAndView.setViewName("userCreated");
        modelAndView.addObject("create", userService.addUser(user));
        return modelAndView;
    }

    @GetMapping(path = "/get")
    public UserEntity get(@RequestParam Long id) {
        return userService.getById(id);
    }

    @GetMapping("/update")
    public ModelAndView update(ModelAndView modelAndView) {
        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user", new UserEntity());
        modelAndView.addObject("users", userService.findAllUsers());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute UserEntity user, ModelAndView modelAndView) {
        modelAndView.setViewName("userUpdated");
        modelAndView.addObject("update", userService.update(user));
        return modelAndView;
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(ModelAndView modelAndView) {
        modelAndView.setViewName("deleteUser");
        modelAndView.addObject("userDeleted", new UserEntity());
        modelAndView.addObject("users", userService.findAllUsers());
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView delete(@ModelAttribute UserEntity user, ModelAndView modelAndView) {
        modelAndView.setViewName("userDeleted");
        modelAndView.addObject("user", userService.getById(user.getId()));
        userService.delete(user.getId());
        return modelAndView;
    }

    @GetMapping(path = "/all")
    public List<UserEntity> getAllUsers() {
        return userService.findAllUsers();
    }
}
