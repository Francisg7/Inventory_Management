package com.eurekadevops.sabre.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @ModelAttribute("section")
    private String getSection() {
        return "dashboard";
    }
    
    @GetMapping
    public String dashboard() {
        return "dashboard";
    }

}
