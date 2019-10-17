package com.neobis.eshop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/*

{
    "id": 1,
    "quantity": 1,
    "price": 1.2,
    "orderDate": null,
    "total": 12.432,
    "order_id": 1,
    "product": null
}

*/

@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer id;

    @Column(name = "quantity", updatable = false)
    private Integer quantity;

    @Column(name = "price", updatable = false)
    private BigDecimal price;

    @Column(name = "order_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "total", updatable = false)
    private BigDecimal total;

    @Column(name = "order_id",nullable = false, updatable = false)
    private Integer order_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private ProductEntity product;

    public OrderItemEntity() {
    }

    public OrderItemEntity(Integer quantity, BigDecimal price, Date orderDate, BigDecimal total, Integer order_id, ProductEntity product) {
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
        this.total = total;
        this.order_id = order_id;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}