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
public class SpringMvcSecurityConfiguration {

//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user1 = User.withUsername("sindu").password("{noop}sindu").roles("EMPLOYEE")
//				.build();
//        return new InMemoryUserDetailsManager(user1);
//    }
	
	@Autowired
	private DataSource securityDataSource;

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(securityDataSource);
	}

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin()
//		.loginPage("/showLoginForm").loginProcessingUrl("/authenticateTheUser")
		.permitAll();
		return http.build();
	}
}
