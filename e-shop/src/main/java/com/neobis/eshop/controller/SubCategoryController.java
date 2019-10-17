package com.neobis.eshop.controller;

import com.neobis.eshop.entity.SubCategoryEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @GetMapping("/{id}")
    public SubCategoryEntity findSubCategoryById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return subCategoryRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<SubCategoryEntity> findAllSubCategoryById(){
        return subCategoryRepository.findAll();
    }

    @PostMapping("/")
    public SubCategoryEntity changeSubCategory(@RequestBody SubCategoryEntity subCategoryEntity){
        return subCategoryRepository.save(subCategoryEntity);
    }

    @PutMapping("/{id}")
    public SubCategoryEntity saveSubCategory(@PathVariable("id") @RequestBody SubCategoryEntity subCategory){
        return subCategoryRepository.save(subCategory);
    }

    @DeleteMapping("/{id}")
    public String deleteSubCategoryById(@PathVariable("id") Integer id ){
        subCategoryRepository.deleteById(id);
        return String.format("Deleted SubCategory #%d", id);
    }
}
