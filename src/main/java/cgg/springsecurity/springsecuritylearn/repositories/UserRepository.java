package cgg.springsecurity.springsecuritylearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springsecurity.springsecuritylearn.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User,String> {
    
    public User findByUsername(String username);
}
