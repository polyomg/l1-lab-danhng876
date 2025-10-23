package poly.edu.lab8.config;

import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import poly.edu.lab8.entity.Account;

import java.util.Date;

@Component
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Account user = (Account) request.getSession().getAttribute("user");
        String name = (user != null) ? user.getFullname() : "ANONYMOUS";
        System.out.printf("URI: %s | Time: %s | User: %s%n",
                request.getRequestURI(), new Date(), name);
        return true;
    }
}
