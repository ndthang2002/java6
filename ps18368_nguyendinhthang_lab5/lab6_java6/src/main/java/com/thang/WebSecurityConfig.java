package com.thang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
   
	
	//ma hoa mat khau
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return  new BCryptPasswordEncoder();
	}
	
	//quản lí sử dụng dữ liệu người dùng
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser("user1").password(pe.encode("123")).roles("GUEST")
		.and()
		.withUser("user2").password(pe.encode("123")).roles("USER","GUEST")
		.and()
		.withUser("user3").password(pe.encode("123")).roles("ADMIN","USER","GUEST");
	    }
	
	// phân quyền và sử dụng hình thức đăng nhập
		
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().cors().disable();
		
		//phân quyền sử dụng 
//		http.authorizeHttpRequests()
//		.antMatchers("/home/index","/auth/login/**").permitAll()
//		.anyRequest().authenticated();
		
		//Phân quyền sử dụng 
//		http.authorizeRequests()
//		.antMatchers("/home/admins").hasRole("ADMIN")
//		.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
//		.antMatchers("/home/authenticated").authenticated()
//		.anyRequest().permitAll();
//		
//		http.exceptionHandling()
//		.accessDeniedPage("/auth/access/denied");
		
	   //Phân quền sử dụng '
		http.authorizeRequests()
		.anyRequest().permitAll();
		
		//giao diện đăng nhập
//		http.httpBasic();
		//giao dien tự viết
		http.formLogin()
		    .loginPage("/auth/login/form")
		    .loginProcessingUrl("/auth/login")
		    .defaultSuccessUrl("/auth/login/success",false)
		    .failureUrl("/auth/login/error")
		    .usernameParameter("username")
		    .passwordParameter("password");
		http.rememberMe()
		.rememberMeParameter("remember");
		
		// đăng xuất
		http.logout()
		.logoutUrl("/auth/logoff")//logout
		.logoutSuccessUrl("/auth/logoff/success");
	}	
}
