package poly.edu.lab8.config;

import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import poly.edu.lab8.entity.Account;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final HttpSession session;

    public AuthInterceptor(HttpSession session) {
        this.session = session;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        session.setAttribute("securityUri", uri);

        Account user = (Account) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/auth/login");
            return false;
        }

        // Nếu người dùng không phải admin mà truy cập /admin/**
        if (uri.startsWith("/admin") && !user.isAdmin()) {
            response.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
