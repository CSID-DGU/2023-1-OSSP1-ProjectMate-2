package com.AkobotWeb.config;

import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

public class MvcConfiguration implements WebMvcConfigurer {

    /* static>template를 기본 경로로 configuration*/
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/") // static을 기본 경로로도 추가 하고 싶다면 이부분 수정
                .setCacheControl(CacheControl.maxAge(10,TimeUnit.MINUTES)); // 캐시 관련 부분 요청에 대한 캐시를 10분으로 지정
    }
}
