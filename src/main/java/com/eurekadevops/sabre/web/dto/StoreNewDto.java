package com.eurekadevops.sabre.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StoreNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    
    @NotNull(message = "is required")
    private String status;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String address;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String city;

    public StoreNewDto() {
    }

    public StoreNewDto(String name, String status, String address, String city) {
        this.name = name;
        this.status = status;
        this.address = address;
        this.city = city;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "StoreNewDto{" + "name=" + name + ", status=" + status + ", address=" + address + ", city=" + city + '}';
    }

}
