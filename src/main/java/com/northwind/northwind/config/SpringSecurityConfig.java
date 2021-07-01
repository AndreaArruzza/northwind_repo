package com.northwind.northwind.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.northwind.northwind.service.NorthwindUserDetailService;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public NorthwindUserDetailService usersDetailService() {
		return new NorthwindUserDetailService();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(usersDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Autowired
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
//		auth.inMemoryAuthentication()
//        .withUser("admin").password(passwordEncoder().encode("admin")).roles("adm");
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable() // disable CSRF for this application
        .formLogin() // Using form based login instead of Basic Authentication
        .loginProcessingUrl("/oauth/token") // Endpoint which will process the authentication request. This is where we will post our credentials to authenticate
        .and()
        .authorizeRequests()
        .antMatchers("/oauth/token").permitAll() // Enabling URL to be accessed by all users (even un-authenticated)
        .antMatchers("/swagger-ui.html").permitAll()
         //.antMatchers("/secure/admin").access("hasRole('ADMIN')") // Configures specified URL to be accessed with user having role as ADMIN
        .anyRequest().authenticated() // Any resources not mentioned above needs to be authenticated
        .and()
//        .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
//        .authenticationEntryPoint(customAuthenticationEntryPoint)
        //.and()
        .anonymous().disable(); 
		
//		
//		http.authorizeRequests()
//        .antMatchers("/")
//        .permitAll()
//        .antMatchers("/home")
//        .hasAuthority("USER")
//        .antMatchers("/admin")
//        .hasAuthority("ADMIN")
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
		//.rememberMe()
		//.tokenRepository(persistentTokenRepository()).and();
	}	
	
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		
//	}
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//	    auth.inMemoryAuthentication()
//	        .withUser("ANTON").password(passwordEncoder().encode("user1Pass")).roles("USER")
//	        .and()
//	        .withUser("AROUT").password(passwordEncoder().encode("user2Pass")).roles("USER")
//	        .and()
//	        .withUser("ALFKI").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//	}

	

	
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
}
