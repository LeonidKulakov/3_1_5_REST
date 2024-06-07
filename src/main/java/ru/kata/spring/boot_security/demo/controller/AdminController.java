package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "test")
    public String printMainPage(ModelMap model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("user", user);
        return "mainPage";
    }


    @PostMapping(value = "add")
    public String add(@ModelAttribute("user") User user,
                      @RequestParam("rolesArray") String[] rolesArray) {
        userService.add(userService.addRoles(user, rolesArray));
        return "redirect:/admin/test";
    }


    @PostMapping(value = "update")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("rolesArray") String[] rolesArray) {
        userService.updateUser(userService.addRoles(user, rolesArray));
        return "redirect:/admin/test";
    }


    @PostMapping(value = "delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/test";
    }


}
