package com.eurekadevops.sabre.web.dto;

import com.eurekadevops.sabre.entity.Employee;
import com.eurekadevops.sabre.entity.Group;
import com.eurekadevops.sabre.web.validation.PasswordMatches;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class LoginNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String username;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;
    
    private String confirmPassword;
    
    @NotNull(message = "is required")
    private Long employeeId;
    
    @NotNull(message = "is required")
    private Long groupId;
    
    private List<Employee> employees = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    public LoginNewDto() {
    }

    public LoginNewDto(String username, String password, String confirmPassword, Long employeeId, Long groupId) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.employeeId = employeeId;
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "LoginNewDto{" + "username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword + ", employeeId=" + employeeId + ", groupId=" + groupId + ", employees=" + employees + ", groups=" + groups + '}';
    }

}
