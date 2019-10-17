package com.neobis.eshop.entity;

import javax.persistence.*;
import java.util.List;

/*
{
    "id": 1,
    "name": null,
    "productId": null
}
 */
@Entity
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)

    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    private List<ProductEntity> products;

    public TagEntity() {
    }

    public TagEntity(String name, List<ProductEntity> products) {
        this.name = name;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
