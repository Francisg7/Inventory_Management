package com.eurekadevops.sabre.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is requied")
    private String name;
    
    @NotNull(message = "is required")
    private String status;

    public CategoryNewDto() {
    }

    public CategoryNewDto(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CategoryNewDto{" + "name=" + name + ", status=" + status + '}';
    }

}
