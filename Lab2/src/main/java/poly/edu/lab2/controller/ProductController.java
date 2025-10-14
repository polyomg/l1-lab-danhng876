package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.lab2.model.Product;

@Controller
@RequestMapping("/bai3")
public class ProductController {

    @GetMapping("/form")
    public String form() {
        return "bai3";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        model.addAttribute("product", product);
        return "bai3";
    }
}
