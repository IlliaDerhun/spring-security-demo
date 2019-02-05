package com.github.illiaderhun.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

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
}
