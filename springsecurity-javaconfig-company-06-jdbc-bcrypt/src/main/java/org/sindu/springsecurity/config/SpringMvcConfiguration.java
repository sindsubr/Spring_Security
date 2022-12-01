package org.sindu.springsecurity.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("org.sindu.springsecurity")
@EnableWebMvc
@PropertySource("classpath:persistence-mysql.properties")
public class SpringMvcConfiguration implements WebMvcConfigurer{
	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	Environment env;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/View/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		logger.info(env.getProperty("jdbc.url"));
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		securityDataSource.setMaxPoolSize(getInt(env.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMinPoolSize(getInt(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxIdleTime(getInt(env.getProperty("connection.pool.maxIdleTime")));
		return securityDataSource;

	}

	public Integer getInt(String val) {
		return Integer.parseInt(val);
		
	}
}
