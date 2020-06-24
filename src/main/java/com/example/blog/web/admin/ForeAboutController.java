package com.example.blog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForeAboutController {


    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
