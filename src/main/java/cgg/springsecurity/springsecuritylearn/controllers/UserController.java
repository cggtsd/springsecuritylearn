package cgg.springsecurity.springsecuritylearn.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.springsecurity.springsecuritylearn.model.User;
import cgg.springsecurity.springsecuritylearn.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //api to get all users
    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    //api to get single user
    @GetMapping("/{username}")
    public User getUserByName(@PathVariable String username){
        return this.userService.getUser(username);
    }

    //api to create user
    @PostMapping("/")
    public User addUser(@RequestBody User user){
       return this.userService.createUser(user);
    }
}
