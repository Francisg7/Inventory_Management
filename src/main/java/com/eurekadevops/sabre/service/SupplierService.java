package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Location;
import com.eurekadevops.sabre.entity.Supplier;
import com.eurekadevops.sabre.repository.SupplierRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.SupplierNewDto;
import com.eurekadevops.sabre.web.errors.SupplierNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements CrudService<Supplier> {
    
    @Autowired 
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getOne(Long id) throws RuntimeException {
        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(String.format("Supplier with id '%d' not found", id)));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        return new SupplierNewDto();
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void save(Dto dto) {
        SupplierNewDto supplierNewDto = (SupplierNewDto) dto;
        
        Supplier supplier = new Supplier();
        
        supplier.setCompanyName(supplierNewDto.getCompanyName());
        supplier.setPhoneNumber(supplierNewDto.getPhoneNumber());
        supplier.setLocation(new Location(supplierNewDto.getAddress(), supplierNewDto.getCity()));
        
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Supplier t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
