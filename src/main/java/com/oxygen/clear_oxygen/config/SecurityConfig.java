package com.oxygen.clear_oxygen.config;

import com.oxygen.clear_oxygen.filter.JwtAuthenticationTokenFilter;
import com.oxygen.clear_oxygen.headler.AccessDeniedHandlerImpl;
import com.oxygen.clear_oxygen.headler.AuthenticationEntryPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 注入认证过滤器
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/system/login").anonymous()
                .anyRequest().authenticated();

        http
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);// 认证过滤器

        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler); // 认证授权失败处理器

        http.cors();// 允许跨域访问
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
