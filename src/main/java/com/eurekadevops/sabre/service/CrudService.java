package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.web.dto.Dto;
import java.util.List;

public interface CrudService<T extends Object> {
    
    public List<T> getAll();
    
    public T getOne(Long id) throws RuntimeException;
    
    public Dto getNewDto() throws RuntimeException;
    
    public Dto getUpdateDto(Long id) throws RuntimeException;
    
    public void save(T t);
    
    public void save(Dto dto);
    
    public void delete(Long id) throws RuntimeException;
    
    public void update(T t);
    
    public void update(Dto dto) throws RuntimeException;

}
