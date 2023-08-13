package com.gestionstock.gero.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("methode WebSecurityConfig SecurityFilterChain filterChain Debut");
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/resources/**", "/css/**", "/img/**", "/scss/**", "/vendor/**", "/js/**", "/static/**", "/webjars/**").permitAll()
                        .anyRequest().authenticated()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login").permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable
                )
                .cors(AbstractHttpConfigurer::disable);
        System.out.println("methode WebSecurityConfig SecurityFilterChain filterChain Fin");


        return http.build();
    }


   /* @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }*/


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println("methode BCryptPasswordEncoder passwordEncoder");
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        System.out.println("methode DaoAuthenticationProvider authenticationProvider 0");

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        System.out.println("methode DaoAuthenticationProvider authenticationProvider 1");

        authProvider.setUserDetailsService(userDetailsService);
        System.out.println("methode DaoAuthenticationProvider authenticationProvider 2");

        authProvider.setPasswordEncoder(passwordEncoder());
        System.out.println("methode DaoAuthenticationProvider authenticationProvider 3");


        return authProvider;
    }



}
