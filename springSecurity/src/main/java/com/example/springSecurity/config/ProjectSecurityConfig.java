package com.example.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//Method level security enable kirma
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                //step 1
                //path access karana methode 2k thiynwa hasAuthority eki hasRole ekai hasAuthority eke nikanma role name eka danmama athi
                //hasRole eke capital walin table eke ROLE_USER lesa thibiya uthu athara methana USER lesa liwiya uthui
//                .antMatchers("/api/v1/account/my-account").hasAuthority("ADMIN")
//                .antMatchers("/api/v1/loan/my-loan").hasRole("USER")

                //step 2 (using Method level security) mehidi adala controller ekin role eka laba dei
                .antMatchers("/api/v1/account/my-account").authenticated()
                .antMatchers("/api/v1/loan/my-loan").authenticated()

                //onama kenekuta access laba gnaimata permitAll yoda gni
                .antMatchers("/api/v1/notice/my-notice","/api/v1/login/register").permitAll()
                .and().formLogin().and().httpBasic();
        return http.build();

    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("1234")
//                .authorities("admin")
//                .build();
//        return new  InMemoryUserDetailsManager(admin);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y);
    }


}
