package org.choongang.configs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.member.service.LoginFailureHandler;
import org.choongang.member.service.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.formLogin(f -> {
      f.loginPage("/member/login")
          .usernameParameter("username")
          .passwordParameter("password")
          .successHandler(new LoginSuccessHandler())
          .failureHandler(new LoginFailureHandler());
//        .defaultSuccessUrl("/")
//        .failureUrl("/member/login?error=true");
    });


    http.logout(c -> {
      c.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
          .logoutSuccessUrl("/member/login");
    });
    /* 인증 설정 E - 로그인, 로그아웃 */

    /* 인증 설정 S - 접근 통제 */
    http.authorizeHttpRequests(c -> {
      c.requestMatchers("/mypage/**")
          .authenticated()
          .requestMatchers("/admin/**")
          .hasAnyAuthority("ADMIN", "MANAGER")
          .anyRequest().permitAll();//그 외 모든 페이지는 모든 접근 가능
    });

    http.exceptionHandling(c -> {
      c.authenticationEntryPoint(new AuthenticationEntryPoint() {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        }
      });
    });
    /* 인가 설정 E - 접근 통제 */
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

