package com.neobis.eshop.controller;

import com.neobis.eshop.entity.OrderItemEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/{id}")
    public OrderItemEntity findOrderItemById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return orderItemRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<OrderItemEntity> findAllOrderItemById(){
        return orderItemRepository.findAll();
    }

    @PostMapping("/")
    public OrderItemEntity changeOrderItem(@RequestBody OrderItemEntity orderItemEntity){
        return orderItemRepository.save(orderItemEntity);
    }

    @PutMapping("/{id}")
    public OrderItemEntity saveOrderItem(@PathVariable("id") @RequestBody OrderItemEntity orderItem){
        return orderItemRepository.save(orderItem);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderItemById(@PathVariable("id") Integer id ){
        orderItemRepository.deleteById(id);
        return String.format("Deleted OrderItem #%d", id);
    }
}
