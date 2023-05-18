package com.AkobotWeb.config.auth;


import com.AkobotWeb.domain.User.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화 시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면 사용하기 위해
                .and()
                .authorizeRequests() // URL 별 권환 관리 설정
                .antMatchers("/","/dongguk","/login","/ask","/add" ,"/vendor/**","/css/**", "/img/**", "/js/**", "/h2/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //andMatcher 권환 관리 대상을 지정하는 옵션 p181
                .anyRequest().authenticated() // 설정값들 외 나머지 URL // 인증된 사용자들에게만 허용
                .and()
                .logout().logoutSuccessUrl("/") // 로그아웃 기능에 대한 진입점, 성공시 /주소로 이동
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); // OAuth2 로그인 기능에 대한 진입점,
                //OAuth2 로그인 성공 이후 사용자 정보를 가져올 떄의 설정등
                //소셜 로그인 성공 후 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
    }
}