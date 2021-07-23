package com.eurekadevops.sabre.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "order_tbl")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_address")
    private String customerAddress;
    
    @Column(name = "customer_phone")
    private String customerPhone;
    
    @Column(name = "gross_amount")
    private Double grossAmount;
    
    @Column(name = "vat_charge")
    private Double vatCharge;
    
    @Column(name = "vat_amount")
    private Double vatAmount;
    
    @Column(name = "discount")
    private Double discount;
    
    @Column(name = "net_amount")
    private Double netAmount;
    
    @Column(name = "paid")
    private Boolean paid;
    
    @Column(name = "order_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    
    @OneToMany(mappedBy = "primaryKey.order", cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    public Order() {
    }

    public Order(String customerName, String customerAddress, String customerPhone, Double grossAmount, Double vatCharge, Double vatAmount, Double discount, Double netAmount, Boolean paid, Date orderDate) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.grossAmount = grossAmount;
        this.vatCharge = vatCharge;
        this.vatAmount = vatAmount;
        this.discount = discount;
        this.netAmount = netAmount;
        this.paid = paid;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", grossAmount=" + grossAmount + ", vatCharge=" + vatCharge + ", vatAmount=" + vatAmount + ", discount=" + discount + ", netAmount=" + netAmount + ", paid=" + paid + ", orderDate=" + orderDate + ", orderProducts=" + orderProducts + '}';
    }
}
