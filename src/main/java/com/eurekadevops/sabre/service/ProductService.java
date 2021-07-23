package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Product;
import com.eurekadevops.sabre.repository.CategoryRepository;
import com.eurekadevops.sabre.repository.ProductRepository;
import com.eurekadevops.sabre.repository.StoreRepository;
import com.eurekadevops.sabre.repository.SupplierRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.ProductNewDto;
import com.eurekadevops.sabre.web.errors.ProductNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CrudService<Product> {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private SupplierRepository supplierRepository;
    
    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(Long id) throws RuntimeException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Product with id '%d' not found", id)));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        ProductNewDto productNewDto = new ProductNewDto();
        
        productNewDto.setCategories(categoryRepository.findAll());
        productNewDto.setSuppliers(supplierRepository.findAll());
        productNewDto.setStores(storeRepository.findAll());
        
        return productNewDto;
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Product t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Dto dto) {
        ProductNewDto productNewDto = (ProductNewDto) dto;
        
        Product product = new Product();
        
        product.setName(productNewDto.getName());
        product.setPrice(productNewDto.getPrice());
        product.setQty(productNewDto.getQty());
        product.setDescription(productNewDto.getDescription());
        product.setAvailability(productNewDto.getAvailability());
        product.setCategory(categoryRepository.getOne(productNewDto.getCategoryId()));
        product.setSupplier(supplierRepository.getOne(productNewDto.getSupplierId()));
        product.setStore(storeRepository.getOne(productNewDto.getStoreId()));
        
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Product t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
