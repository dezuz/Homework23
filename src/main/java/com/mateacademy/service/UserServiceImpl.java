package com.mateacademy.service;

import com.mateacademy.model.Role;
import com.mateacademy.model.User;
import com.mateacademy.repository.RoleRepository;
import com.mateacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public void saveUser(User user) {
        user.setPassword(user.getPassword());
        Role userRole = roleRepository.findByName("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
       userRepository.deleteById(id);
    }

    @Override
    public User findUserByEmail(User user) {
        return userRepository.findByEmail(user.getEmail());
    }
}
