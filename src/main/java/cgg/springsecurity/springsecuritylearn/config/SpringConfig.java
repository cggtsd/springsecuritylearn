package cgg.springsecurity.springsecuritylearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringConfig {
    

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(authz -> authz.anyRequest().authenticated()).httpBasic(withDefaults());
        return http.build();

    }
    @Bean
     UserDetailsService userDetailsService(){

        UserDetails adminUser = User.withUsername("fathima").password(this.passwordEncoder().encode("fathima")).roles("ADMIN").build();
        UserDetails normalUser = User.withUsername("abc").password(this.passwordEncoder().encode("abc")).roles("NORMAL").build();

        return new InMemoryUserDetailsManager(normalUser,adminUser);

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
