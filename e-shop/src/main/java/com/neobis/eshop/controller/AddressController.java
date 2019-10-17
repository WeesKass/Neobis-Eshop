package com.neobis.eshop.controller;

import com.neobis.eshop.entity.AddressEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/{id}")
    public AddressEntity findAddressById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return addressRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<AddressEntity> findAllAddressById(){
        return addressRepository.findAll();
    }

    @PostMapping("/")
    public AddressEntity changeAddress(@RequestBody AddressEntity addressEntity){
        return addressRepository.save(addressEntity);
    }

    @PutMapping("/{id}")
    public AddressEntity saveAddress(@PathVariable("id") @RequestBody AddressEntity addressEntity){
        return addressRepository.save(addressEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteAddressById(@PathVariable("id") Integer id ){
        addressRepository.deleteById(id);
        return String.format("Deleted Address #%d", id);
    }
}
