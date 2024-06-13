package ru.kata.spring.boot_security.demo.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;
@RestController
public class Test {
    private final UserService userService;

    public Test(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.listUsers();
        return userList == null && userList.isEmpty() ?
                new ResponseEntity<>(userList, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @PostMapping(value = "/users")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid Object o) {
        System.out.println("Я работаю");
        System.out.println(o.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("admin/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        final User user = userService.findById(id);
        System.out.println(user);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
