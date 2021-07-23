package com.eurekadevops.sabre.entity;

import com.eurekadevops.sabre.entity.util.OrderProductId;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "order_products_tbl")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.order", joinColumns = @JoinColumn(name = "order_id")),
    @AssociationOverride(name = "primaryKey.product", joinColumns = @JoinColumn(name = "product_id"))
})
public class OrderProduct {
    
    // composite-id key
    private OrderProductId primaryKey = new OrderProductId();
    
    // additional fields
    private Long qty;
    
    @EmbeddedId
    public OrderProductId getPrimaryKey() {
        return this.primaryKey;
    } 
    
    public void setPrimaryKey(OrderProductId primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    @Transient
    public Order getOrder() {
        return this.getPrimaryKey().getOrder();
    }
    
    public void setOrder(Order order) {
        this.getPrimaryKey().setOrder(order);
    }
    
    @Transient
    public Product getProduct() {
        return this.getPrimaryKey().getProduct();
    }
    
    public void setProduct(Product product) {
        this.getPrimaryKey().setProduct(product);
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderProduct{" + "primaryKey=" + primaryKey + ", qty=" + qty + '}';
    }
    
}
