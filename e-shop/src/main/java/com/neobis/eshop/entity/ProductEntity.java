package com.neobis.eshop.entity;

import javax.persistence.*;
import java.util.List;
/*
{
    "id": 1,
    "name": "1231313131",
    "description": "",
    "likes": 1,
    "dislikes": 1,
    "subCategory": null,
    "productInfos": null
}
 */
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name =  "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name =  "likes")
    private Integer likes;

    @Column(name = "dislikes")
    private Integer dislikes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_category_id",referencedColumnName = "sub_category_id")
    private SubCategoryEntity subCategory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<ProductInfoEntity> productInfos;

    @Column(name = "tag_id")
    private Integer tag;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private List<ImageEntity> images;

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, Integer likes, Integer dislikes, SubCategoryEntity subCategory, List<ProductInfoEntity> productInfos, Integer tag, List<ImageEntity> images) {
        this.name = name;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.subCategory = subCategory;
        this.productInfos = productInfos;
        this.tag = tag;
        this.images = images;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public SubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategoryEntity subCategoryEntity) {
        this.subCategory = subCategoryEntity;
    }

    public List<ProductInfoEntity> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfoEntity> productInfos) {
        this.productInfos = productInfos;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }
}

