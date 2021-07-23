package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Location;
import com.eurekadevops.sabre.entity.Store;
import com.eurekadevops.sabre.repository.LocationRepository;
import com.eurekadevops.sabre.repository.StoreRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.StoreNewDto;
import com.eurekadevops.sabre.web.errors.StoreNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService implements CrudService<Store> {
    
    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getOne(Long id) throws RuntimeException {
        return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException(String.format("Store with id '%d' not found", id)));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        return new StoreNewDto();
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Store store) {
        storeRepository.save(store);
    }

    @Override
    public void save(Dto dto) {
        StoreNewDto storeNewDto = (StoreNewDto) dto;
        
        Store store = new Store();
        
        store.setName(storeNewDto.getName());
        store.setStatus(storeNewDto.getStatus());
        store.setLocation(new Location(storeNewDto.getAddress(), storeNewDto.getCity()));
        
        storeRepository.save(store);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Store t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
