package org.sindu.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringWebMvcSecurityConfiguration{

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withUsername("jhon").password("{noop}test@123").roles("employee")
				.build();
		UserDetails user2 = User.withUsername("mary").password("{noop}test@123").roles("manager")
				.build();
		UserDetails user3 = User.withUsername("sam").password("{noop}test@123").roles("admin")
				.build();
		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests()
//		.anyRequest().authenticated()
		.antMatchers("/showAdmin").hasAnyRole("admin")
		.antMatchers("/showLeader").hasAnyRole("manager")
		.and().formLogin().loginPage("/showLoginForm")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
		return http.build();
	}
}
