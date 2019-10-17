package com.neobis.eshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "product_info")
public class ProductInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_info_id")
    private Integer id;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private BigInteger quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "product_id")
    private Integer productId;

    public ProductInfoEntity() {
    }

    public ProductInfoEntity(String size, BigInteger quantity, BigDecimal unitPrice, Integer productId) {
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
