package cgg.springsecurity.springsecuritylearn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cgg.springsecurity.springsecuritylearn.model.User;
import cgg.springsecurity.springsecuritylearn.repositories.UserRepository;

@Service
public class UserService {
    

    private UserRepository userRepository;

    
    // private List<User> users= new ArrayList<>();
    
    // public UserService(){
    //     users.add(new User("abc","abc","abc@gmail.com"));
    //     users.add(new User("xyz","xyz","xyz@gmail.com"));

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // }
   // get all users
    public List<User> getAllUsers(){

        return this.userRepository.findAll();
    }

    //get single user
    public User getUser(String username){
        return this.userRepository.findByUsername(username);
    }

    //add user
    public User createUser(User user){
       this.userRepository.save(user);
        return user;
    }
}
