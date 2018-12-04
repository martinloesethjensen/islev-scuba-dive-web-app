package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication;

import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.base.Session;
import com.theopensourcerers.islevwebapplication3rdsemesterexamproject.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static String prefix = "";
    private static int myId = 0;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/member/*").access("hasAnyAuthority('ROLE_MEMBER')")
                .antMatchers("/admin/*").access("hasAnyAuthority('ROLE_ADMIN')")
                .antMatchers("/login", "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                        for(GrantedAuthority grantedAuthority: authorities) {
                            if (grantedAuthority.getAuthority().equals("ROLE_MEMBER")) {
                                Integer sessionId = sessionRepository.findByUsernameEquals(((UserDetails) authentication.getPrincipal()).getUsername()).getId();
                                myId = (sessionRepository.findByIdEquals(sessionId)).getId();
                                prefix = "/member";
                                httpServletResponse.sendRedirect("/member/");
                            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                                Integer sessionId = sessionRepository.findByUsernameEquals(((UserDetails)authentication.getPrincipal()).getUsername()).getId();
                                myId = (sessionRepository.findByIdEquals(sessionId)).getId();
                                prefix = "/admin";
                                httpServletResponse.sendRedirect("/admin/");
                            }
                        }
                    }
                })
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<Session> _tempSessions = sessionRepository.findAll();

        UserDetails[] users = new UserDetails[_tempSessions.size()];

        int i = 0;

        for(Session session: _tempSessions) {
            users[i] = User.withUsername(session.getUsername()).password("{noop}"+session.getPassword()).roles(session.getRole()).build();
            i++;
        }

        return new InMemoryUserDetailsManager(users);
    }
}
