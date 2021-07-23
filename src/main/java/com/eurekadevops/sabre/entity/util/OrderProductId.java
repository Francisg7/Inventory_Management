package com.eurekadevops.sabre.entity.util;

import com.eurekadevops.sabre.entity.Order;
import com.eurekadevops.sabre.entity.Product;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderProductId implements Serializable {
    
    private Order order;
    
    private Product product;
    
    @ManyToOne(cascade = CascadeType.ALL)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProductId{" + "order=" + order + ", product=" + product + '}';
    }
    
}
