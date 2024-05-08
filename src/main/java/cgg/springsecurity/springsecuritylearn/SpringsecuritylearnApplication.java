package cgg.springsecurity.springsecuritylearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import cgg.springsecurity.springsecuritylearn.model.User;
import cgg.springsecurity.springsecuritylearn.repositories.UserRepository;


@SpringBootApplication
public class SpringsecuritylearnApplication implements CommandLineRunner{
    @Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritylearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("fathima",bCryptPasswordEncoder.encode("fathima"),"fathima@gmail.com","ROLE_ADMIN");
		User user1 = new User("abc",bCryptPasswordEncoder.encode("abc"),"abc@gmail.com","ROLE_NORMAL");

		this.userRepository.save(user);
		this.userRepository.save(user1);

	}

}
