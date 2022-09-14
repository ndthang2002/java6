package com.thang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.thang.interceptor.GlobalInterceptor;

@Configuration
    
public class InterceptorConfig implements WebMvcConfigurer {
    
	
	@Autowired
	GlobalInterceptor GlobalInterceptor;
    
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(GlobalInterceptor)
         .addPathPatterns("/**")
         .excludePathPatterns("/rest/**","/admin/**","/assets/**"); 
	}
}
