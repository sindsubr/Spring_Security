# Spring_Security

<h1>Topics</h1>
<i>
<ol>
<li> Spring Config with JAVA</li>
<li> Spring Security Config (Default Login and logout)</li>
<li> Spring Security Config (Custom Login)</li>
<li> Spring Security Config (Custom Login) with error param check</li>
<li> Spring Security Config (Custom Bootstrap Login)</li>
<li> Spring Security Config (Custom Bootstrap Login) with CSRF</li>
<li> Spring Security Config : user role disply in jsp</li>
<li> Spring Security Config : Access Denied Page </li>
<li> Spring Security Config : Restrict Access Based On Roles </li>
<li> Spring Security JDBC </li>
<li> Spring SecurityJDBC with Password Encryption(Bcrypt hashing)</li>
</ol>
</i>
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
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<c:if test = "${param.error!=null }">
		<i class="error"> Bad Credentials</i>
	</c:if>
	</code>
	
<br><br>

<h2>Spring Security Config (Custom Bootstrap Login) with CSRF</h2>
<br><br>
<h3>Custom-bootstrap-login</h3>
<b>Note:</b>The <code> <form:form> </code>tag automagically implements csrf token code
	
	<code>
		<!-- CSRF token assignment for form tag in Spring Security Framework -->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</code>

<br><br>
	
<h2>User Role Display in JSP</h2>
<br><br>
<h3>main.jsp</h3>
	

<code>	
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	
<security:authentication property = "principal.username"></security:authentication>
<security:authentication property = "principal.authorities"></security:authentication>
</code>
	
<h2>Creating Project:</h2>
<br><br>
<b> Issue #1 </b>
Error in main
The superclass <i>"javax.servlet.http.HttpServlet"</i>, determined from the Dynamic Web Module facet version (2.3), was not found on the Java 
 Build Path
 
 <b> Solution #1: </b>
 Add javax.servlet-api in pom.xml -> update maven and build project
