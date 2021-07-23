package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.service.OrderService;
import com.eurekadevops.sabre.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private SettingsService settingsService;

    @ModelAttribute("section")
    public String getSection() {
        return "orders";
    }

    @GetMapping
    public String orders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }
    
    @GetMapping("/add")
    public String showOrderForm(Model model) {
        model.addAttribute("vat", settingsService.getOne(1L).getVatCharge());
        return "order-form";
    }
    
}
