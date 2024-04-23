package cgg.springsecurity.springsecuritylearn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cgg.springsecurity.springsecuritylearn.model.User;

@Service
public class UserService {
    

    private List<User> users= new ArrayList<>();
    
    public UserService(){
        users.add(new User("abc","abc","abc@gmail.com"));
        users.add(new User("xyz","xyz","xyz@gmail.com"));

    }
    //get all users
    public List<User> getAllUsers(){

        return this.users;
    }

    //get single user
    public User getUser(String username){
        return users.stream().filter(user->user.getUsername().equals(username)).findAny().orElse(null);
    }

    //add user
    public User createUser(User user){
        this.users.add(user);
        return user;
    }
}
