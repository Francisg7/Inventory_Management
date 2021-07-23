package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.service.SettingsService;
import com.eurekadevops.sabre.web.dto.SettingsUpdateDto;
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
@RequestMapping("/settings")
public class SettingsController {
    
    @Autowired
    private SettingsService settingsService;
    
    @ModelAttribute("section")
    public String getSection() {
        return "settings";
    }
    
    @GetMapping
    public String settings(Model model) {
        model.addAttribute("settings", settingsService.getOne(1L));
        return "settings";
    }
    
    @GetMapping("/update")
    public String showSettingsFormForUpdate(Model model) {
        model.addAttribute("settings", settingsService.getUpdateDto(1L));
        return "settings-form";
    }
    
    @PostMapping("/update")
    public String updateSettings(@Valid @ModelAttribute(name = "settings") SettingsUpdateDto settingsUpdateDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "settings-form";
        } else {
            settingsService.update(settingsUpdateDto);
            return "redirect:/settings";
        }
    }

}
