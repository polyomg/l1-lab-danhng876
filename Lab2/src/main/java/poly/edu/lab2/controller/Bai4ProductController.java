package poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.lab2.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/bai4")
public class Bai4ProductController {

    //form lưu tt
    @GetMapping("/form")
    public String form(Model model) {
        Product p = new Product("iPhone 11", 5000.0);
        model.addAttribute("product", p);
        return "bai4";
    }

    //ds có sẵn
    private List<Product> items = new ArrayList<>(Arrays.asList(
            new Product("Laptop Dell", 1200.0),
            new Product("Samsung Galaxy", 800.0),
            new Product("Sony TV", 1500.0)
    ));

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        items.add(p); //thêm vào ds nhập

        model.addAttribute("product", p);
        return "bai4";
    }

    //hiển thị list trong form
    @ModelAttribute("items")
    public List<Product> getItems() {
        return items;
    }
}
