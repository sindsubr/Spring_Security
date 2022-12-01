package org.sindu.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringWebMvcSecurityConfiguration {

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(securityDataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/showAdmin").hasRole("ADMIN")
		.antMatchers("/showLeader").hasRole("MANAGER")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/showLoginForm")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and().exceptionHandling()
				.accessDeniedPage("/access-denied");
		return http.build();
	}

}
