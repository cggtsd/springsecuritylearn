package cgg.springsecurity.springsecuritylearn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import cgg.springsecurity.springsecuritylearn.services.CustomUserDetailsService;

@Configuration
@EnableMethodSecurity
public class SpringConfig {
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
         CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        http
        .csrf(
            csrf->csrf.csrfTokenRepository(
                CookieCsrfTokenRepository.withHttpOnlyFalse())
               .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler))
        .authorizeHttpRequests(authz -> 
        authz
        .requestMatchers("/signin").permitAll()
        // .requestMatchers("/public/**").hasAuthority("ROLE_NORMAL")
        // .requestMatchers("/users/**").hasAuthority("ROLE_ADMIN")
        .anyRequest().authenticated())
        .formLogin(
            login->
            login.loginPage("/signin")
            .loginProcessingUrl("/doLogin")
            .defaultSuccessUrl("/users/",true)
           
            )
            .logout(logout->logout.logoutUrl("/logout").logoutSuccessUrl("/signin?logout"));
            
            
        return http.build();

    }
    // @Bean
    //  UserDetailsService userDetailsService(){

        // UserDetails adminUser = User.withUsername("fathima").password(this.passwordEncoder().encode("fathima")).roles("ADMIN").build();
        // UserDetails normalUser = User.withUsername("abc").password(this.passwordEncoder().encode("abc")).roles("NORMAL").build();

        // return new InMemoryUserDetailsManager(normalUser,adminUser);
    //     return customUserDetailsService;

    // }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider getProvider(){
          DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
          daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
          daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
          return daoAuthenticationProvider;
    }
}
