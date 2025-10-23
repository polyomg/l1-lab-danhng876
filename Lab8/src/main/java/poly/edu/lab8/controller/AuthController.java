package poly.edu.lab8.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.lab8.entity.Account;
import poly.edu.lab8.service.AccountService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        Account acc = accountService.findById(username);
        if (acc == null || !acc.getPassword().equals(password)) {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
            return "auth/login";
        }
        session.setAttribute("user", acc);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
