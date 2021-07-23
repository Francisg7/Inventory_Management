package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.service.SupplierService;
import com.eurekadevops.sabre.web.dto.SupplierNewDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;
    
    @ModelAttribute("section")
    public String getSection() {
        return "suppliers";
    }
    
    @GetMapping
    public String showAllSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAll());
        return "suppliers";
    }
    
    @GetMapping("/add")
    public String showSupplierFormForAdd(Model model) {
        model.addAttribute("supplier", supplierService.getNewDto());
        return "supplier-form";
    }
    
    @PostMapping("/add")
    public String addProcess(@Valid @ModelAttribute(name = "supplier") SupplierNewDto supplierNewDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "supplier-form";
        } else {
            supplierService.save(supplierNewDto);
            return "redirect:/suppliers";
        }
    }

}
