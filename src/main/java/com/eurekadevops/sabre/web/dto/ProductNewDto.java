package com.eurekadevops.sabre.web.dto;

import com.eurekadevops.sabre.entity.Category;
import com.eurekadevops.sabre.entity.Store;
import com.eurekadevops.sabre.entity.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1)
    private String name;
    
    @NotNull(message = "is required")
    private Double price;
    
    @NotNull(message = "is required")
    private Long qty;
    
    @NotNull(message = "is required")
    @Size(min = 1)
    private String description;
    
    @NotNull(message = "is required")
    @Size(min = 1)
    private String availability;
    
    @NotNull(message = "is required")
    private Long categoryId;
    
    @NotNull(message = "is required")
    private Long supplierId;
    
    @NotNull(message = "is required")
    private Long storeId;
    
    private List<Category> categories = new ArrayList<>();
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Store> stores = new ArrayList<>();

    public ProductNewDto() {
    }

    public ProductNewDto(String name, Double price, Long qty, String description, String availability, Long categoryId, Long supplierId, Long storeId) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.availability = availability;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "ProductNewDto{" + "name=" + name + ", price=" + price + ", qty=" + qty + ", description=" + description + ", availability=" + availability + ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", storeId=" + storeId + ", categories=" + categories + ", suppliers=" + suppliers + ", stores=" + stores + '}';
    }
    
}
