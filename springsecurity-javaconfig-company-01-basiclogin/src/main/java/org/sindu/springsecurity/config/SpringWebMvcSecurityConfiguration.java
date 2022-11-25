package org.sindu.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringWebMvcSecurityConfiguration {

	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("jhon")
				.password("test@123").roles("EMPLOYEE").build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
            .username("mary").password("test@123").roles("manager").build();
        UserDetails user3 = User.withDefaultPasswordEncoder()
            .username("sam").password("test@123").roles("admin")
            .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
}
