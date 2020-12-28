package com.gen.com.Insurance_portal.controllers;

import com.gen.com.Insurance_portal.services.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/home")
public class HomeController {

    private final IRoleService roleService;

    public HomeController(IRoleService roleService) {
        this.roleService = roleService;
    }


    @RequestMapping("/swagger")
    public String home() {
        return "redirect:/swagger-ui.html";
    }

    @RequestMapping
    public String hello() {
        return "Welcome to here!";
    }



}
