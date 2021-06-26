//package com.northwind.northwind.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//	    auth.inMemoryAuthentication()
//	        .withUser("Ana Trujillo").password(passwordEncoder().encode("user1Pass")).roles("USER")
//	        .and()
//	        .withUser("Maria Anders").password(passwordEncoder().encode("user2Pass")).roles("USER")
//	        .and()
//	        .withUser("Christina Berglund").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//	}
//
//	
//	@Bean 
//	public PasswordEncoder passwordEncoder() { 
//	    return new BCryptPasswordEncoder(); 
//	}
//	
//	
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//	    http
//	      .csrf().disable()
//	      .authorizeRequests()
//	      .antMatchers("**").hasRole("USER")
//	      .and().formLogin();
////	      .antMatchers("/anonymous*").anonymous()
////	      .antMatchers("/login*").permitAll()
////	      .anyRequest().authenticated()
////	      .and()
//	      // ...
//	}
//}
