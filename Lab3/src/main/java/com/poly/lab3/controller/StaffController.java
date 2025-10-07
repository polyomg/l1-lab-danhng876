package com.poly.lab3.controller;

import com.poly.lab3.model.Staff;
import com.poly.lab3.model.StaffBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    // sample single staff detail
    @RequestMapping("/detail")
    public String detail(Model model) {
        Staff staff = new StaffBuilder()
                .id("user1@gmail.com")
                .fullname("Nguyễn Văn User1")
                .photo("/images/photo1.jpg")   // đặt file ảnh trong static/images
                .gender(true)
                .birthday(StaffBuilder.parse("1997-12-23"))
                .salary(12345.678)
                .level(0)
                .build();
        model.addAttribute("staff", staff);
        return "staff-detail";
    }

    // list of staff
    @RequestMapping("/list")
    public String list(Model model) {
        List<Staff> list = new ArrayList<>();
        for (int i=1;i<=6;i++){
            Staff s = new StaffBuilder()
                    .id("user"+i+"@gmail.com")
                    .fullname("Nguyễn Văn User"+i)
                    .photo("/images/photo1.jpg")
                    .gender(i % 2 == 0)
                    .birthday(StaffBuilder.parse("1990-01-0"+(i%9+1)))
                    .salary(51234.56)
                    .level(i%3)
                    .build();
            list.add(s);
        }
        model.addAttribute("list", list);
        return "staff-list";
    }

    // status table (index,count,first,last,odd,even)
    @RequestMapping("/status")
    public String status(Model model) {
        List<String> items = new ArrayList<>();
        items.add("Nguyễn Văn User1");
        items.add("Nguyễn Văn User2");
        items.add("Nguyễn Văn User3");
        items.add("Nguyễn Văn User4");
        items.add("Nguyễn Văn User5");
        items.add("Nguyễn Văn User6");
        model.addAttribute("items", items);
        return "staff-status";
    }

    // list controls: select box + radio group
    @RequestMapping("/controls")
    public String controls(Model model) {
        List<Staff> list = new ArrayList<>();
        for (int i=1;i<=6;i++){
            Staff s = new StaffBuilder()
                    .id("user"+i+"@gmail.com")
                    .fullname("nguyễn văn user"+i)
                    .level(i)
                    .build();
            list.add(s);
        }
        model.addAttribute("list", list);
        return "list-controls";
    }
}
