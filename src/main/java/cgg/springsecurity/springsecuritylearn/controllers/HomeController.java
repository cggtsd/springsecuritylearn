package cgg.springsecurity.springsecuritylearn.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_NORMAL')")
public class HomeController {
    
    @GetMapping("/home")
    public String home(){
        return "this is home page";
    }

    @GetMapping("/login")
    public String login(){
        return "this is login page";
    }

    @GetMapping("/register")
    public String register(){
        return "this is register page";
    }
}
