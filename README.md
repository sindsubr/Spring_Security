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



<a href="https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter">spring-security-without-the-websecurityconfigureradapter</a>
<br><br>
Creating Project:
<br><br>
<b> Issue #1 </b>
Error in main
The superclass <i>"javax.servlet.http.HttpServlet"</i>, determined from the Dynamic Web Module facet version (2.3), was not found on the Java 
 Build Path
 
 <b> Solution #1: </b>
 Add javax.servlet-api in pom.xml -> update maven and build project
