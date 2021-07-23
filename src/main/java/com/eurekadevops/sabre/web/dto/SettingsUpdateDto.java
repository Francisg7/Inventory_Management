package com.eurekadevops.sabre.web.dto;

import com.eurekadevops.sabre.entity.Settings;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SettingsUpdateDto extends Dto {

    private Long id;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String companyName;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String phoneNumber;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String email;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String country;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String address;
    
    @NotNull(message = "is required")
    private Double vatCharge;

    public SettingsUpdateDto() {
    }
    
    public SettingsUpdateDto(Settings settings) {
        this.id = settings.getId();
        this.companyName = settings.getCompanyName();
        this.phoneNumber = settings.getPhoneNumber();
        this.email = settings.getEmail();
        this.country = settings.getCountry();
        this.address = settings.getAddress();
        this.vatCharge = settings.getVatCharge();
    }

    public SettingsUpdateDto(String companyName, String phoneNumber, String email, String country, String address, Double vatCharge) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.country = country;
        this.address = address;
        this.vatCharge = vatCharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getVatCharge() {
        return vatCharge;
    }

    public void setVatCharge(Double vatCharge) {
        this.vatCharge = vatCharge;
    }

    @Override
    public String toString() {
        return "SettingsUpdateDto{" + "id=" + id + ", companyName=" + companyName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", country=" + country + ", address=" + address + ", vatCharge=" + vatCharge + '}';
    }
    
}
