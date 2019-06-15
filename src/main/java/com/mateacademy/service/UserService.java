package com.mateacademy.service;

import com.mateacademy.model.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity addUser(UserEntity user);

    List<UserEntity> findAllUsers();

    UserEntity getById(Long id);

    UserEntity update(UserEntity user);

    void delete(Long id);

    UserEntity findUserByEmail(UserEntity user);

    void saveUser(UserEntity user);
}
