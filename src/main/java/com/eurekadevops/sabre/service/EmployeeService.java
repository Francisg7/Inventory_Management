package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Employee;
import com.eurekadevops.sabre.entity.Location;
import com.eurekadevops.sabre.repository.EmployeeRepository;
import com.eurekadevops.sabre.repository.StoreRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.EmployeeNewDto;
import com.eurekadevops.sabre.web.errors.EmployeeNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements CrudService<Employee> {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOne(Long id) throws RuntimeException {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with id '%d' not found")));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        EmployeeNewDto employeeNewDto = new EmployeeNewDto();
        employeeNewDto.setStores(storeRepository.findAll());
        
        return employeeNewDto;
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void save(Dto dto) {
        EmployeeNewDto employeeNewDto = (EmployeeNewDto) dto;
        Employee employee = new Employee();
        
        employee.setFirstName(employeeNewDto.getFirstName());
        employee.setLastName(employeeNewDto.getLastName());
        employee.setEmail(employeeNewDto.getEmail());
        employee.setPhoneNumber(employeeNewDto.getPhoneNumber());
        employee.setHiredDate(employeeNewDto.getHiredDate());
        employee.setLocation(new Location(employeeNewDto.getAddress(), employeeNewDto.getCity()));
        employee.setStore(storeRepository.getOne(employeeNewDto.getStoreId()));
        
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Employee t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
