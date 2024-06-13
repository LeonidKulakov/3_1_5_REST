package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();

    void add(User user);

    void updateUser(User user);

    void delete(Long id);
    User findByUsername(String username);
    User addRoles(User user, String[] roles);
    User findById(Long id);
}
