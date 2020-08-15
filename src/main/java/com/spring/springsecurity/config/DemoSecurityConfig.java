package com.spring.springsecurity.config;

import javax.sql.DataSource;

import com.spring.dao.UserRepository;
import com.spring.springsecurity.config.jwttoken.JwtAuthenticationFilter;
import com.spring.springsecurity.config.jwttoken.JwtAuthorizationFilter;
import com.spring.springsecurity.config.userdetailsconfigration.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserPrincipalDetailsService userPrincipalDetailsService;
	private UserRepository userRepository;

	public DemoSecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		// add jwt filters (1. authentication, 2. authorization)
		.addFilter(new JwtAuthenticationFilter(authenticationManager()))
		.addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository))
		.authorizeRequests()
		.antMatchers("/index").permitAll()
		.and()
		.formLogin()
		.loginProcessingUrl("/signin")
		.loginPage("/userlogin").permitAll()
		.usernameParameter("txtusername")
		.passwordParameter("txtpassword")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/userlogin");

		/*http.authorizeRequests()
		.antMatchers("/index").permitAll()
		.and()
		.formLogin()
		.loginProcessingUrl("/signin")
		.loginPage("/userlogin").permitAll()
		.usernameParameter("txtusername")
		.passwordParameter("txtpassword")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/userlogin");

		 */
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}