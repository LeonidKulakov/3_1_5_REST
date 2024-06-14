package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(RoleRepository roleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userRepository.findAll();
    }


    @Override
    public void add(UserDTO user) {
        User userForBD = new User();
        userForBD.setUsername(user.getUsername());
        userForBD.setCity(user.getCity());
        userForBD.setAge(user.getAge());
        userForBD.setPassword(passwordEncoder.encode(user.getPassword()));
        userForBD.setRoles(user.getRoles());
        userRepository.save(userForBD);
    }

    @Override
    public void updateUser(UserDTO user) {
        User userFromDB = userRepository.findById(user.getId()).get();
        userFromDB.setUsername(user.getUsername());
        userFromDB.setAge(user.getAge());
        userFromDB.setCity(user.getCity());
        userFromDB.setPassword(passwordEncoder.encode(user.getPassword()));
        userFromDB.setRoles(user.getRoles());
        userRepository.save(userFromDB);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addRoles(User user, String[] roles) {
        user.setRoles(Arrays.stream(roles).map(el -> roleRepository.findByName("ROLE_".concat(el)).get())
                .collect(Collectors.toList()));
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
