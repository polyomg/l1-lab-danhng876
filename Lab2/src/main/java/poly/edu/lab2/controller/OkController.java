package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai1")
public class OkController {

    // ✅ Thêm method này để hiển thị form
    @GetMapping("/form")
    public String form() {
        return "bai1"; // trỏ tới file src/main/resources/templates/bai1.html
    }

    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("result", "Đã gọi Post()");
        return "bai1";
    }

    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("result", "Đã gọi Get()");
        return "bai1";
    }

    @RequestMapping("/ok2")
    public String m3(Model model) {
        model.addAttribute("result", "Đã gọi RequestMapping()");
        return "bai1";
    }
}
