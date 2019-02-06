package com.github.illiaderhun.controller;

import com.github.illiaderhun.entity.User;
import com.github.illiaderhun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    @GetMapping("/access-denied")
    public String showForbidden() {
        return "access-denied";
    }

    @PostMapping("/register")
    public String showRegistration(Model theModel) {
        User user = new User();

        theModel.addAttribute("user", user);

        return "registration";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid
                           @ModelAttribute("user")
                               User theUser, BindingResult result, WebRequest request) {
        if (result.hasErrors()) {
            return "redirect:/register";
        }
        userService.saveUser(theUser);
        return "redirect:/";
    }
}
