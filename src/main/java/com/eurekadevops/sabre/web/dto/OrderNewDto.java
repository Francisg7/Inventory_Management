package com.eurekadevops.sabre.web.dto;

import com.eurekadevops.sabre.web.utils.ProductQty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderNewDto extends Dto {
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String customerName;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String customerAddress;
    
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String customerPhone;
    
    @NotNull(message = "is required")
    private Double grossAmount;
    
    @NotNull(message = "is required")
    private Double vatCharge;
    
    @NotNull(message = "is required")
    private Double vatAmount;
    
    @NotNull(message = "is required")
    private Double discount;
    
    @NotNull(message = "is required")
    private Double netAmount;
    
    @NotEmpty
    private List<ProductQty> productQtys;

    public OrderNewDto() {
    }

    public OrderNewDto(String customerName, String customerAddress, String customerPhone, Double grossAmount, Double vatCharge, Double vatAmount, Double discount, Double netAmount, List<ProductQty> productQtys) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.grossAmount = grossAmount;
        this.vatCharge = vatCharge;
        this.vatAmount = vatAmount;
        this.discount = discount;
        this.netAmount = netAmount;
        this.productQtys = productQtys;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Double getVatCharge() {
        return vatCharge;
    }

    public void setVatCharge(Double vatCharge) {
        this.vatCharge = vatCharge;
    }

    public Double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public List<ProductQty> getProductQtys() {
        return productQtys;
    }

    public void setProductQtys(List<ProductQty> productQtys) {
        this.productQtys = productQtys;
    }

    @Override
    public String toString() {
        return "OrderNewDto{" + "customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", grossAmount=" + grossAmount + ", vatCharge=" + vatCharge + ", vatAmount=" + vatAmount + ", discount=" + discount + ", netAmount=" + netAmount + ", productQtys=" + productQtys + '}';
    }

}
