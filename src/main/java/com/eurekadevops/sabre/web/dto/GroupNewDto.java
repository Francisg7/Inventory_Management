package com.eurekadevops.sabre.web.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GroupNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    
    private List<String> permissions;

    public GroupNewDto() {
    }

    public GroupNewDto(String name, List<String> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "GroupNewDto{" + "name=" + name + ", permissions=" + permissions + '}';
    }
}
