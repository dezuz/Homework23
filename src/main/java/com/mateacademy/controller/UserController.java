package com.mateacademy.controller;

import com.mateacademy.model.User;
import com.mateacademy.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public ModelAndView addUser(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView addUser(@ModelAttribute User user, ModelAndView modelAndView) {
        modelAndView.setViewName("userCreated");
        modelAndView.addObject("create", userService.addUser(user));
        return modelAndView;
    }

    @GetMapping(path = "/get")
    public User get(@RequestParam Long id) {
        return userService.getById(id);
    }

    @GetMapping("/update")
    public ModelAndView update(ModelAndView modelAndView) {
        modelAndView.setViewName("update");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("users", userService.findAllUsers());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute User user, ModelAndView modelAndView) {
        modelAndView.setViewName("userUpdated");
        modelAndView.addObject("update", userService.update(user));
        return modelAndView;
    }

    @GetMapping(path = "/delete")
    public ModelAndView delete(ModelAndView modelAndView) {
        modelAndView.setViewName("delete");
        modelAndView.addObject("userDeleted", new User());
        modelAndView.addObject("users", userService.findAllUsers());
        return modelAndView;
    }

    @PostMapping(path = "/delete")
    public ModelAndView delete(@ModelAttribute User user, ModelAndView modelAndView) {
        modelAndView.setViewName("userDeleted");
        modelAndView.addObject("user", userService.getById(user.getId()));
        userService.delete(user.getId());
        return modelAndView;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}
