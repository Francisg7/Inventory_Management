package com.eurekadevops.sabre.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SupplierNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String companyName;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String phoneNumber;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String address;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String city;

    public SupplierNewDto() {
    }

    public SupplierNewDto(String companyName, String phoneNumber, String address, String city) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "SupplierNewDto{" + "companyName=" + companyName + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city=" + city + '}';
    }

}
