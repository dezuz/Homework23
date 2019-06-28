package com.mateacademy.service;

import com.mateacademy.model.Role;
import com.mateacademy.model.UserEntity;
import com.mateacademy.repository.RoleRepository;
import com.mateacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
       userRepository.deleteById(id);
    }

    @Override
    public UserEntity findUserByEmail(UserEntity user) {
        return userRepository.findByEmail(user.getEmail());
    }
}
