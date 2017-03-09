package ru.ocean.animals.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Map<String, String> roleUrlMap;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("ROLE_ADMIN",       "/index");
        map.put("ROLE_USER",        "/index");
        map.put("ROLE_KORM",        "/index");
        map.put("ROLE_IHTI",        "/index");
        map.put("ROLE_DIRECTOR",    "/index");
        map.put("ROLE_BIOLOGY",     "/index");

        roleUrlMap = Collections.unmodifiableMap(map);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String role = userDetails.getAuthorities().isEmpty() ? null : userDetails.getAuthorities().toArray()[0].toString();
            response.sendRedirect(request.getContextPath() + roleUrlMap.get(role));
        }
    }
}
