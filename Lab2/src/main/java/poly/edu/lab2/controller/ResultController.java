package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/result")
public class ResultController {

    // /result/a
    @RequestMapping("/a")
    public String m1() {
        return "bai5"; // gọi view bai5.html
    }

    // /result/b
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "bai5"; // hiển thị message trong view bai5.html
    }

    // /result/c
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/result/a";
    }

    // /result/d
    @RequestMapping("/d")
    @ResponseBody
    public String m4() {
        return "I come from d";
    }
}
