package ru.kata.spring.boot_security.demo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.DTO.AddUserDTO;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataCreator implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserService userService;

    public DataCreator(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createUser();
    }

    private void createUser() {
//        userService.add(new User("user", "user", 18, "Рязань", roleRepository.findAll()));
        userService.add(new AddUserDTO("user",18,"Рязань","user",roleRepository.findAll()));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("ROLE_USER").get());
        userService.add(new AddUserDTO("11",11,"11","11",roles));
    }

    private void createRoles() {
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            roleRepository.save(new Role(1L, "ROLE_USER"));
        }
        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            roleRepository.save(new Role(2L, "ROLE_ADMIN"));
        }
    }
}
