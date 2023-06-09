package com.akobot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /* static>template를 기본 경로로 configuration*/
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                //.addResourceLocations("classpath:/templates/") // static을 기본 경로로도 추가 하고 싶다면 이부분 수정
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES)); // 캐시 관련 부분 요청에 대한 캐시를 10분으로 지정

        registry.addResourceHandler("static/css/**")
                .addResourceLocations("classpath:/static/css/")
                .setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES)); // 캐시 관련 부분 요청에 대한 캐시를 10분으로 지정

        registry.addResourceHandler("static/js/**")
                .addResourceLocations("classpath:/static/js/")
                .setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES)); // 캐시 관련 부분 요청에 대한 캐시를 10분으로 지정

        registry.addResourceHandler("static/img/**")
                .addResourceLocations("classpath:/static/img/")
                .setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES)); // 캐시 관련 부분 요청에 대한 캐시를 10분으로 지정
    }
}
