package com.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
    @GetMapping("/home")
 public String home()
 {
     System.out.println("home");

     return "this is home page";
 }

    @GetMapping("/login")
    public String login()
    {
        System.out.println("login");

        return "this is login page";
    }

}
