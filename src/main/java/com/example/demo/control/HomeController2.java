package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController2 {

    @PostMapping("/home")
    public String postHome(@RequestParam String message, Model model) {
        model.addAttribute("message", message);
        return "home";
    }
}
