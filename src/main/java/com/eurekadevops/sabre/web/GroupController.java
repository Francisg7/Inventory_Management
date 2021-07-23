package com.eurekadevops.sabre.web;

import com.eurekadevops.sabre.entity.Group;
import com.eurekadevops.sabre.service.GroupService;
import com.eurekadevops.sabre.web.dto.GroupNewDto;
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
@RequestMapping("/groups")
public class GroupController {
    
    @Autowired
    public GroupService groupService;
    
    private Logger logger = LoggerFactory.getLogger(GroupController.class);
    
    @ModelAttribute("section")
    private String getSection() {
        return "groups";
    }
    
    @ModelAttribute("groups")
    public List<Group> getAllGroup() {
        return groupService.getAll();
    }
    
    @GetMapping
    public String jobs(Model model) {
        return "groups";
    }
    
    @GetMapping("/add")
    public String showGroupFormForAdd(Model model) {
        model.addAttribute("group", groupService.getNewDto());
        return "group-form";
    }
    
    @PostMapping("/add")
    public String addProcess(@Valid @ModelAttribute("group") GroupNewDto groupNewDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "group-form";
        } else {
            groupService.save(groupNewDto);
            model.addAttribute("success", "Group created successfully");
            return "groups";
        }
    }

}
