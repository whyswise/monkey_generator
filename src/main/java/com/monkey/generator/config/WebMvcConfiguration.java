package com.monkey.generator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.monkey.generator.controller.MonkeyInterceptor;

//인터셉터(전,후처리) 설정 파일
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Autowired
	MonkeyInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor).excludePathPatterns("/assets/**");
	}
	

}
