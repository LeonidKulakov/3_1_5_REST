package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.DTO.AddUserDTO;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.DTO.EditUserDTO;

import java.util.List;

public interface UserService {
    List<User> listUsers();


    void add(AddUserDTO user);

    void updateUser(EditUserDTO user);

    void delete(Long id);
    User findByUsername(String username);
    User addRoles(User user, String[] roles);
    User findById(Long id);
}
