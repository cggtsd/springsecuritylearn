package cgg.springsecurity.springsecuritylearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springsecurity.springsecuritylearn.model.Role;

public interface RoleRepository  extends JpaRepository<Role,Integer>{
    
}
