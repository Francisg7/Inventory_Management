package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Category;
import com.eurekadevops.sabre.repository.CategoryRepository;
import com.eurekadevops.sabre.web.dto.CategoryNewDto;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.errors.CategoryNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CrudService<Category> {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getOne(Long id) throws RuntimeException {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(String.format("Category with id '%d' not found")));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        return new CategoryNewDto();
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Category t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Dto dto) {
        CategoryNewDto categoryNewDto = (CategoryNewDto) dto;
        
        Category category = new Category();
        
        category.setName(categoryNewDto.getName());
        category.setStatus(categoryNewDto.getStatus());
        
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Category t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
