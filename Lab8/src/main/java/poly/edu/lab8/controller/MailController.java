package poly.edu.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import poly.edu.lab8.service.MailService;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/form")
    public String showForm() {
        return "mail/form";
    }

    @ResponseBody
    @GetMapping("/send")
    public String sendMail(@RequestParam String to,
                           @RequestParam String subject,
                           @RequestParam String body) {
        mailService.send(to, subject, body);
        return "Mail đã được gửi đi thành công!";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return """
                 MailController đang hoạt động!<br>
                <a href='/mail/form'>Quay lại form gửi mail</a>
                """;
    }
}
