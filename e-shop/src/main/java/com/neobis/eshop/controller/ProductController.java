package com.neobis.eshop.controller;

import com.neobis.eshop.entity.ProductEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{id}")
    public ProductEntity findProductById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return productRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<ProductEntity> findAllProductById(){
        return productRepository.findAll();
    }

    @PostMapping("/")
    public ProductEntity changeProduct(@RequestBody ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    @PutMapping("/{id}")
    public ProductEntity saveProduct(@PathVariable("id") @RequestBody ProductEntity product){
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Integer id ){
        productRepository.deleteById(id);
        return String.format("Deleted Product #%d", id);
    }
}
