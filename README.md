# Spring_Security

<h2>Notes:</h2>

<h3 style="color='red';">Dependencies Needed: </h3>
<b><i>pom.xml</b></i> <br>
<ol>
<li>javax.servlet-api</li>
<li>javax.servlet-jsp-api</li>
<li>jstl</li>
<li>spring-webmvc</li>
<li>javax.security-web</li>
<li>javax.security-config</li>
<li>javax.security-taglibs</li>

</ol>
For recent Spring update,<br>
<a href="https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter">spring-security-without-the-websecurityconfigureradapter</a>

<h2>Spring Security's Basic Login Functionality Implementation:</h2>
<br><br>
<h3>Security Configuration:</h3>

File: SpringWebMvcSecurityConfiguration.java
Add @EnableWebSecurity to enable servlet filter security functionalities

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


<h3>For index.jsp</h3>

Implement logout function using logout param just create a button logout within <form:form> tag<br><br>
<code>
 <%@ page isELIgnored="false"%>
  <br><br>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br><br>
<%@taglib prefix="c" uri="http://www.java.sun.com/jsp/jstl/core" %>
 </code>

<h2>Spring Security's Custom Login Functionality Implementation:</h2>
<br><br>
<h3>Security Configuration:</h3>

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin().loginPage("/showLoginForm")
		.loginProcessingUrl("/authenticateTheUser")
			.permitAll();
		return http.build();
	}

<h3> custom-logic.jsp</h3><br>
You have to create custom login form with error param checking<br>
<code>
<%@page isELIgnored = "false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %></code>

	<c:if test = "${param.error!=null }">
		<i class="error"> Bad Credentials</i>
	</c:if>

<br><br>



<h2>Creating Project:</h2>
<br><br>
<b> Issue #1 </b>
Error in main
The superclass <i>"javax.servlet.http.HttpServlet"</i>, determined from the Dynamic Web Module facet version (2.3), was not found on the Java 
 Build Path
 
 <b> Solution #1: </b>
 Add javax.servlet-api in pom.xml -> update maven and build project
