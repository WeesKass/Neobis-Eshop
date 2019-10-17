package com.neobis.eshop.entity;

import javax.persistence.*;

 /*

    {
        "id": 1,
        "city": "CITY",
        "country": "COUNTRY",
        "postal_code": "POSTAL_CODE",
        "firstName": "First Name",
        "lastName": "Last Name",
        "address": "address?'
    }

     */

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "order_id")
    private OrderEntity order;

    public AddressEntity() {
    }

    public AddressEntity(String city, String country, String postal_code, String firstName, String lastName, OrderEntity order) {
        this.city = city;
        this.country = country;
        this.postal_code = postal_code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}

