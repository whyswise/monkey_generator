package com.monkey.generator;

//import org.apache.ibatis.annotations.Mapper;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
//기본 시작 파일  스캔할 기본 패키지들 선언
@ComponentScan({"com.monkey.generator.util","com.monkey.generator","com.monkey.generator.config","com.monkey.generator.controller", "com.monkey.generator.controller.exception","com.monkey.generator.model","com.monkey.generator.service","com.monkey.generator.validate"})
@SpringBootApplication
public class MonkeyGeneratorApplication extends SpringBootServletInitializer {
	
	public MonkeyGeneratorApplication() {
        super();
        setRegisterErrorPageFilter(false); // <- this one
    }

	public static void main(String[] args) {
		SpringApplication.run(MonkeyGeneratorApplication.class, args);
	}

}
