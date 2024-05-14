package cgg.springsecurity.springsecuritylearn;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import cgg.springsecurity.springsecuritylearn.model.Role;
import cgg.springsecurity.springsecuritylearn.model.User;
import cgg.springsecurity.springsecuritylearn.repositories.RoleRepository;
import cgg.springsecurity.springsecuritylearn.repositories.UserRepository;


@SpringBootApplication
public class SpringsecuritylearnApplication implements CommandLineRunner{
    @Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritylearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role("ROLE_ADMIN");
		
		Role role1 = new Role("ROLE_NORMAL");
		this.roleRepository.save(role);
		this.roleRepository.save(role1);

		User user = new User("fathima",bCryptPasswordEncoder.encode("fathima"),"fathima@gmail.com",
		Arrays.asList(role,role1));
		User user1 = new User("abc",bCryptPasswordEncoder.encode("abc"),"abc@gmail.com",Arrays.asList(role1));

		this.userRepository.save(user);
		this.userRepository.save(user1);

	}

}
