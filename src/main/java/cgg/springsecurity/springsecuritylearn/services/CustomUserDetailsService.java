package cgg.springsecurity.springsecuritylearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cgg.springsecurity.springsecuritylearn.model.CustomUserDetails;
import cgg.springsecurity.springsecuritylearn.model.User;
import cgg.springsecurity.springsecuritylearn.repositories.UserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = this.userRepository.findByUsername(username);
       if(user==null){
        throw new UsernameNotFoundException("No User Found");
       }
       return new CustomUserDetails(user);
    }
    
}
