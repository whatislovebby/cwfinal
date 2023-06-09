package com.bsuir.course.config;

import com.bsuir.course.domain.User;
import com.bsuir.course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/rent/**", "/sale/**", "/login", "/signUp").permitAll()
                .antMatchers("/account/**", "/add").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                // .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .loginPage("/login")
                //.loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/personal")
                .successHandler(new AuthenticationSuccessHandler() {

                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        System.out.println("AuthenticationSuccessHandler invoked");
                        System.out.println("Authentication name: " + authentication.getName());

                        User user = userRepository.findOneByEmail(authentication.getName());
                        //  User user = userService.getMemberByEmail(authentication.getName());
                        System.out.println(authentication.getAuthorities());

                        if (!user.isEnabled()) {
                            if (user.getRoles().toString().equals("[ADMIN]")) {
                                response.sendRedirect("/admin/personal");
                            } else if (user.getRoles().toString().equals("[USER]")) {
                                response.sendRedirect("/account/personal");
                            }
                        }else {
                            response.sendRedirect("/block");
                        }




                    }
                })
                //.defaultSuccessUrl("/list")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }


    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentails, true from _user where email=?")
                .authoritiesByUsernameQuery("select _user_email as principal, role_name as role from _user_roles where _user_email=?")
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // TODO Auto-generated method stub
        return new BCryptPasswordEncoder();
    }

}
