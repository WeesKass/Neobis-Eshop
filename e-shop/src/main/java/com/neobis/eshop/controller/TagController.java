package com.neobis.eshop.controller;

import com.neobis.eshop.entity.TagEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping("/{id}")
    public TagEntity findTagById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return tagRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<TagEntity> findAllTagById(){
        return tagRepository.findAll();
    }

    @PostMapping("/")
    public TagEntity changeTag(@RequestBody TagEntity tagEntity){
        return tagRepository.save(tagEntity);
    }

    @PutMapping("/{id}")
    public TagEntity saveTag(@PathVariable("id") @RequestBody TagEntity tag){
        return tagRepository.save(tag);
    }

    @DeleteMapping("/{id}")
    public String deleteTagById(@PathVariable("id") Integer id ){
        tagRepository.deleteById(id);
        return String.format("Deleted Tag #%d", id);
    }
}
