package com.theopensourcerers.islevwebapplication3rdsemesterexamproject.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomLogoutSuccessHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        WebSecurityConfig.setIsLoggedIn(false);
        WebSecurityConfig.setMyId(0);
        WebSecurityConfig.setPrefix("");
    }
}
