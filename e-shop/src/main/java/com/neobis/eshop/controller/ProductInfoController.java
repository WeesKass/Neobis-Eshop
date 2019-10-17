package com.neobis.eshop.controller;

import com.neobis.eshop.entity.ProductInfoEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @GetMapping("/{id}")
    public ProductInfoEntity findProductInfoById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return productInfoRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<ProductInfoEntity> findAllProductInfoById(){
        return productInfoRepository.findAll();
    }

    @PostMapping("/")
    public ProductInfoEntity changeProductInfo(@RequestBody ProductInfoEntity productInfoEntity){
        return productInfoRepository.save(productInfoEntity);
    }

    @PutMapping("/{id}")
    public ProductInfoEntity saveProductInfo(@PathVariable("id") @RequestBody ProductInfoEntity productInfo){
        return productInfoRepository.save(productInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteProductInfoById(@PathVariable("id") Integer id ){
        productInfoRepository.deleteById(id);
        return String.format("Deleted ProductInfo #%d", id);
    }
}