package com.mateacademy.service;

import com.mateacademy.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> findAllUsers();

    User getById(Long id);

    User update(User user);

    void delete(Long id);

    User findUserByEmail(User user);

    void saveUser(User user);
}
