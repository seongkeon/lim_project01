package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig {
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // JSP 파일이 위치한 디렉토리 지정
        resolver.setSuffix(".jsp"); // JSP 파일의 확장자 지정
        System.out.println("여기 지남!");
        return resolver;
    }
}
