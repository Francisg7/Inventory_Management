package com.eurekadevops.sabre.web.utils;

public class ProductQty {
    
    private Long productId;
    private Long qty;

    public ProductQty() {
    }

    public ProductQty(Long productId, Long qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ProductQty{" + "productId=" + productId + ", qty=" + qty + '}';
    }

}
