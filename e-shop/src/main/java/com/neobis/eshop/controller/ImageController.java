package com.neobis.eshop.controller;

import com.neobis.eshop.entity.ImageEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @GetMapping("/{id}")
    public ImageEntity findImageById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return imageRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<ImageEntity> findAllImageById(){
        return imageRepository.findAll();
    }

    @PostMapping("/")
    public ImageEntity changeImage(@RequestBody ImageEntity imageEntity){
        return imageRepository.save(imageEntity);
    }

    @PutMapping("/{id}")
    public ImageEntity saveImage(@PathVariable("id") @RequestBody ImageEntity image){
        return imageRepository.save(image);
    }

    @DeleteMapping("/{id}")
    public String deleteImageById(@PathVariable("id") Integer id ){
        imageRepository.deleteById(id);
        return String.format("Deleted Image #%d", id);
    }
}