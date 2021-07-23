package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.entity.Login;
import com.eurekadevops.sabre.service.EmployeeService;
import com.eurekadevops.sabre.service.GroupService;
import com.eurekadevops.sabre.service.LoginService;
import com.eurekadevops.sabre.web.dto.LoginNewDto;
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
@RequestMapping("/")
public class AuthController {
    
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private GroupService groupService;
    
    @Autowired
    private EmployeeService employeeService;
    
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @ModelAttribute("section")
    public String getSection() {
        return "logins";
    }
    
    @ModelAttribute("logins")
    public List<Login> getAllLogins() {
        return loginService.getAll();
    }
    
    @GetMapping("/logins")
    public String showAllLogins(Model model) {
        return "logins";
    }
    
    @GetMapping("logins/add")
    public String showLoginFormForAdd(Model model) {
        model.addAttribute("login", loginService.getNewDto());
        return "logins-form";
    }
    
    @PostMapping("logins/add")
    public String addProcess(@Valid @ModelAttribute(name = "login") LoginNewDto loginNewDto, BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            loginNewDto.setGroups(groupService.getAll());
            loginNewDto.setEmployees(employeeService.getAll());
            return "logins-form";
        } else {
            loginService.save(loginNewDto);
            return "redirect:/logins";
        }
        
    }
    
    @GetMapping("/login")
    public String showLoginFormForLogin() {
        return "login-form";
    }
    
}
