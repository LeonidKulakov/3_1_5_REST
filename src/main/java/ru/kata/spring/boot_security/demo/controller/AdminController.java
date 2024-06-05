package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

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

    @GetMapping(value = "add")
    public ModelAndView printAdd() {
        User user = new User();
        ModelAndView mav = new ModelAndView("add");
        mav.addObject("user", user);
        List<Role> roles = roleService.findAll();
        mav.addObject("allRoles", roles);
        return mav;
    }

    @PostMapping(value = "add")
    public String add(User user) {
        userService.add(user);
        return "redirect:/admin/test";
    }

    @GetMapping(value = "update")
    public ModelAndView printUpdate() {
        User user = new User();
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("user", user);
        List<Role> roles = roleService.findAll();
        mav.addObject("allRoles", roles);
        return mav;
    }

    @PostMapping(value = "update")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/admin/test";
    }

    @GetMapping(value = "delete")
    public String printDelete() {
        return "delete";
    }

    @PostMapping(value = "delete")
    public String delete(@RequestParam("id") Long id) {
        System.out.println(111);
        userService.delete(id);
        return "redirect:/admin/test";
    }


}
