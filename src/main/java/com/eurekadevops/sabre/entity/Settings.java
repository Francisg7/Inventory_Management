package com.eurekadevops.sabre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings_tbl")
public class Settings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "vat_charge")
    private Double vatCharge;

    public Settings() {
    }

    public Settings(String companyName, String phoneNumber, String email, String address, String country, Double vatCharge) {
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.country = country;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getVatCharge() {
        return vatCharge;
    }

    public void setVatCharge(Double vatCharge) {
        this.vatCharge = vatCharge;
    }

    @Override
    public String toString() {
        return "Settings{" + "id=" + id + ", companyName=" + companyName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", country=" + country + ", vatCharge=" + vatCharge + '}';
    }

}
