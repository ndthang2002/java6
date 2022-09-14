package com.thang;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.thang.entity.Account;
import com.thang.service.AccountService;

@Configuration
@EnableWebSecurity

public class SercurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountService accountService;
	//cơ chế mã hóa mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// nơi cung cấp nguồn dữ liệu đăng nhập

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		auth.userDetailsService(username->{
			
			try {
				
				Account user = accountService.findById(username);				
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream()
						.map(el->el.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException(username + "not found!");
			}
		});
	}
	
//	cấu hình về phân quyền 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	http.csrf().disable();
	http.authorizeRequests()
	.antMatchers("/order/**").authenticated()
	.antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
	.antMatchers("/rest/authorities").hasRole("DIRE")
	.anyRequest().permitAll();
	
	http.formLogin()
	.loginPage("/security/login/form")
	.loginProcessingUrl("/security/login")
	.defaultSuccessUrl("/security/login/success",false)
	.failureUrl("/security/login/error");
	
	http.rememberMe()
	.tokenValiditySeconds(86400);
	
	http.exceptionHandling()
	.accessDeniedPage("/security/unauthoried");
	
	http.logout()
	.logoutUrl("/security/logoff")
	.logoutSuccessUrl("/security/logoff/success");
	
	//Cho phép truy xuất REST API từ bên ngoài (domain khác)
	

	}	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
}
