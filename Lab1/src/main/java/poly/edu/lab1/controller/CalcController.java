package poly.edu.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalcController {

    @GetMapping("/calc/form")
    public String form() {
        return "calc";
    }

    @PostMapping("/calc/result")
    public String result(Double width, Double height, Model model) {
        double area = width * height;
        double perimeter = 2 * (width + height);

        model.addAttribute("width", width);
        model.addAttribute("height", height);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);

        return "calc";
    }
}
