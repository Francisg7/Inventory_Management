package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Settings;
import com.eurekadevops.sabre.repository.SettingsRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.SettingsUpdateDto;
import com.eurekadevops.sabre.web.errors.SettingsNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements CrudService<Settings> {
    
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public List<Settings> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Settings getOne(Long id) throws RuntimeException {
        return settingsRepository.findById(id).orElseThrow(() -> new SettingsNotFoundException(String.format("Settings with id '%d' not found", id)));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        Settings settings = settingsRepository.findById(id).orElseThrow(() -> new SettingsNotFoundException(String.format("Settings with id '%d' not found", id)));
    
        return new SettingsUpdateDto(settings);
    }

    @Override
    public void save(Settings t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Settings t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        SettingsUpdateDto settingsUpdateDto = (SettingsUpdateDto) dto;
        
        Settings settings = settingsRepository.findById(settingsUpdateDto.getId()).orElseThrow(() -> new SettingsNotFoundException(String.format("Settings with id '%d' not found", settingsUpdateDto.getId())));
    
        settings.setCompanyName(settingsUpdateDto.getCompanyName());
        settings.setPhoneNumber(settingsUpdateDto.getPhoneNumber());
        settings.setEmail(settingsUpdateDto.getEmail());
        settings.setCountry(settingsUpdateDto.getCountry());
        settings.setAddress(settingsUpdateDto.getAddress());
        settings.setVatCharge(settingsUpdateDto.getVatCharge());
        
        settingsRepository.save(settings);
    }

}
