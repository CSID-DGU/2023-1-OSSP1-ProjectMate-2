package com.AkobotWeb.config.auth;


import com.AkobotWeb.domain.User.Role;
import com.AkobotWeb.domain.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면 사용하기 위해
                .and()
                .authorizeRequests() // URL 별 권한 관리 설정
                .antMatchers("/","/dongguk","/login","/ask","/add" ,"/vendor/**","/css/**", "/img/**", "/js/**", "/h2/**", "/h2-console/**", "/api/v1/**").permitAll() // 해당 URL에 대해서는 전부 허용
                .antMatchers("home","tables","manage","questionDetail","solve","solvedDetail","index","manual","how_answer","how_manageDB"
                        ,"/how_notice_question","smsService","mailService","/updateDB","updateDBAtSolvedDetail").hasRole(String.valueOf(Role.ROLE_USER)) // ROLE_USER만 허용
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/") // 로그아웃 기능에 대한 진입점, 성공시 /주소로 이동
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); // OAuth2 로그인 기능에 대한 진입점,
                //OAuth2 로그인 성공 이후 사용자 정보를 가져올 떄의 설정등
                //소셜 로그인 성공 후 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
    }
    @Bean
    public PasswordEncoder passwordEncoder() { // 비밀번호 암호화할 떄 쓰일 객체

        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        auth.userDetailsService(id -> {
            User user = UserRepository.findById(id)
                    .orElseThrow(() -> new IdNotFoundException("User not found with id: " + id));

            return org.springframework.security.core.userdetails.User.builder()
                    .id(user.getId())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
        });
    }
}