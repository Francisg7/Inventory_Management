package com.eurekadevops.sabre.web.dto;

import com.eurekadevops.sabre.entity.Store;
import com.eurekadevops.sabre.web.validation.ValidEmail;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @ValidEmail
    private String email;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String phoneNumber;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String address;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String city;
    
    @NotNull(message = "is required")
    private Date hiredDate;
    
    @NotNull(message = "is required")
    private Long storeId;
    
    private List<Store> stores = new ArrayList<>();

    public EmployeeNewDto() {
    }

    public EmployeeNewDto(String firstName, String lastName, String email, String phoneNumber, String address, String city, Date hiredDate, Long storeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.hiredDate = hiredDate;
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city=" + city + ", hiredDate=" + hiredDate + ", storeId=" + storeId + ", stores=" + stores + '}';
    }

}
