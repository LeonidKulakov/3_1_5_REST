package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;

import java.util.List;

public interface UserService {
    List<User> listUsers();


    void add(UserDTO user);

    void updateUser(UserDTO user);

    void delete(Long id);
    User findByUsername(String username);
    User addRoles(User user, String[] roles);
    User findById(Long id);
}
