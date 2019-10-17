package com.neobis.eshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*

    {
        "id": int,
        "total": double,
        "orderDate": null,
        "status": string,
        "user_id": int,
        "address_id": int
    }
*/

@Entity
@Table(name = "`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "total", updatable = false)
    private BigDecimal total;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "user_id",nullable = false, updatable = false)
    private Integer user_id;

    @Column(name = "address_id")
    private Integer address_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private List<OrderItemEntity> orderItems;

    public OrderEntity() {}

    public OrderEntity(BigDecimal total, Date orderDate, String status, Integer user_id, Integer address_id, List<OrderItemEntity> orderItems) {
        this.total = total;
        this.orderDate = orderDate;
        this.status = status;
        this.user_id = user_id;
        this.address_id = address_id;
        this.orderItems = orderItems;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

}
