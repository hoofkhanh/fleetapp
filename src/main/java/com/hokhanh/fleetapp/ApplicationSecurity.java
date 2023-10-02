package com.hokhanh.fleetapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hokhanh.fleetapp.services.UserService;

@EnableWebSecurity
@Configuration
public class ApplicationSecurity     {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
            .requestMatchers("/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
            .requestMatchers("/users/addNew").permitAll()
            .requestMatchers("/security/user/edit/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/index")
            .permitAll()
        )
        .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
        						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        						.logoutSuccessUrl("/login")
        						.permitAll())
        .exceptionHandling(handling -> handling.accessDeniedPage("/accessDenied"));
		 
		    return http.build();
	}

	
//	@Bean
//	 PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
    
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
	
	@Autowired
	private UserService userService;
	
	
	@Bean
	 public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();	
		authenticationProvider.setUserDetailsService(userService);	
		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());	
		return authenticationProvider;	
	}
}
