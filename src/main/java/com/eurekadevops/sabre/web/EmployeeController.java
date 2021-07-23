package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.entity.Employee;
import com.eurekadevops.sabre.service.EmployeeService;
import com.eurekadevops.sabre.service.StoreService;
import com.eurekadevops.sabre.web.dto.EmployeeNewDto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private StoreService storeService;
    
    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @ModelAttribute("section")
    public String getSection() {
        return "employees";
    }
    
    @ModelAttribute("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping
    public String showAllEmployees(Model model) {
        return "employees";
    }

    @GetMapping("/add")
    public String showEmployeeFormForAdd(Model model) {
        model.addAttribute("employee", employeeService.getNewDto());
        return "employee-form";
    }
    
    @PostMapping("/add")
    public String addProcess(@Valid @ModelAttribute(name = "employee") EmployeeNewDto employeeNewDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            employeeNewDto.setStores(storeService.getAll());
            return "employee-form";
        } else {
            employeeService.save(employeeNewDto);
            
            return "redirect:/employees?success";
        }
    }

}
