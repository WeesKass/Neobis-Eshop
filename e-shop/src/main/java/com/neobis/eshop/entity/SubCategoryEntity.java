package com.neobis.eshop.entity;

import javax.persistence.*;

/*

{
    "id": 1,
    "name": null,
    "description": null,
    "category_id": 1,
    "active": false
}

 */


@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "category_id",nullable = false, updatable = false)
    private Integer category_id;


    public SubCategoryEntity() {
    }

    public SubCategoryEntity(String name, String description, boolean isActive, Integer category_id) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.category_id = category_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
