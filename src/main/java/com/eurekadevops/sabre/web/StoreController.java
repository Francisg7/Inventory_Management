package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.entity.Store;
import com.eurekadevops.sabre.service.StoreService;
import com.eurekadevops.sabre.web.dto.StoreNewDto;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stores")
public class StoreController {
    
    @Autowired
    private StoreService storeService;
    
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @ModelAttribute("section")
    private String getSection() {
        return "stores";
    }
    
    @ModelAttribute("stores")
    public List<Store> getAllStores() {
        return storeService.getAll();
    }
    
    @GetMapping
    public String stores(Model model) {
        return "stores";
    }
    
    @GetMapping("/add")
    public String showStoreFormForAdd(Model model) {
        model.addAttribute("store", storeService.getNewDto());
        return "store-form";
    }
    
    @PostMapping("/add")
    public String addProcess(@Valid @ModelAttribute(name = "store") StoreNewDto storeNewDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "store-form";
        } else {
            storeService.save(storeNewDto);
            model.addAttribute("success", "Store created successfully");
            return "stores";
        }
    }

}
