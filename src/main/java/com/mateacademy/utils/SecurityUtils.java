/*
package com.mateacademy.utils;

import com.mateacademy.model.UserEntity;
import com.mateacademy.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
@Slf4j
public class SecurityUtils {

    @Autowired
    private UserServiceImpl userService;

    public UserEntity getUser(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        User user = (User) token.getPrincipal();

        UserEntity entity = userService.findByFirstName(user.getUsername());

        return entity;
    }

}*/
