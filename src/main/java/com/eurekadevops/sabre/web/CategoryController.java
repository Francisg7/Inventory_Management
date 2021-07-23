package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.service.CategoryService;
import com.eurekadevops.sabre.web.dto.CategoryNewDto;
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
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @ModelAttribute("section")
    public String getSection() {
        return "categories";
    }

    @GetMapping
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "categories";
    }
    
    @GetMapping("/add")
    public String showCategoryFormForAdd(Model model) {
        model.addAttribute("category", categoryService.getNewDto());
        return "category-form";
    }
    
    @PostMapping("/add")
    public String addProcess(@Valid @ModelAttribute(name = "category") CategoryNewDto categoryNewDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category-form";
        } else {
            categoryService.save(categoryNewDto);
            return "redirect:/categories";
        }
    }

}
