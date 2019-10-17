package com.neobis.eshop.controller;

import com.neobis.eshop.entity.CategoryEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public CategoryEntity findCategoryById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return categoryRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<CategoryEntity> findAllCategoryById(){
        return categoryRepository.findAll();
    }

    @PostMapping("/")
    public CategoryEntity changeCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    @PutMapping("/{id}")
    public CategoryEntity saveCategory(@PathVariable("id") @RequestBody CategoryEntity category){
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable("id") Integer id ){
        categoryRepository.deleteById(id);
        return String.format("Deleted Category #%d", id);
    }
}
