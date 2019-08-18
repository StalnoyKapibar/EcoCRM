package ru.javamentor.EcoCRM.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by whitenoise on 18.08.19.
 */
@Component
public class SecurityHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException
    {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        for (String role : roles) {
            System.out.println("Role is: " + role);
        }
        if (roles.contains("ROLE_ADMIN")) {
            System.out.println("role finded");
            httpServletResponse.sendRedirect("/admin/userlist");
        } else if(roles.contains("ROLE_USER")) {
            System.out.println("user role");
            httpServletResponse.sendRedirect("/");
        }
    }
}