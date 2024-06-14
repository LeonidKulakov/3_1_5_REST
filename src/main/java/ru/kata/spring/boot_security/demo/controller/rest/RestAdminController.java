package ru.kata.spring.boot_security.demo.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestAdminController {
    private final UserService userService;

    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.listUsers();
        return userList == null && userList.isEmpty() ?
                new ResponseEntity<>(userList, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(value = "admin/adds")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid UserDTO user) {
        userService.add(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        final User user = userService.findById(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "admin/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping(value = "admin/update")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid UserDTO user) {
        userService.updateUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
