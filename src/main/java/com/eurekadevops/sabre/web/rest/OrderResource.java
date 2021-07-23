package com.eurekadevops.sabre.web.rest;

import com.eurekadevops.sabre.service.OrderService;
import com.eurekadevops.sabre.web.dto.OrderNewDto;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderResource {
    
    @Autowired
    private OrderService orderService;
    
    private Logger logger = LoggerFactory.getLogger(OrderResource.class);
    
    @PostMapping
    public void addOrder(@Valid @RequestBody OrderNewDto orederNewDto) {
        orderService.save(orederNewDto);
    }

}
