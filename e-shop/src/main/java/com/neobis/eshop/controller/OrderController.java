package com.neobis.eshop.controller;


import com.neobis.eshop.entity.OrderEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/{id}")
    public OrderEntity findOrderById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return orderRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<OrderEntity> findAllOrder(){
        return orderRepository.findAll();
    }

    @PostMapping("/")
    public OrderEntity changeOrder(@RequestBody OrderEntity orderEntity){
        return orderRepository.save(orderEntity);
    }

    @PutMapping("/{id}")
    public OrderEntity saveOrder(@PathVariable("id") @RequestBody OrderEntity user){
        return orderRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Integer id ){
        orderRepository.deleteById(id);
        return String.format("Deleted Order #%d", id);
    }

//    @Autowired
//    OrderService orderService;
//
//    @RequestMapping("/")
//    public String defaultOrderEndpoint(){
//        return "Default Order endpoint.";
//    }
//
//    @GetMapping("/{id}")
//    public Order findOrderById(@PathVariable("id") Integer id) throws Exception {
//        return orderService.getOrderById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Order changeOrderById(@PathVariable("id") @RequestBody Order order){
//        return orderService.saveOrder(order);
//    }
//
//    @PostMapping("/")
//    public Order createOrder(@RequestBody Order order){
//        return orderService.saveOrder(order);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteOrderById(@PathVariable("id") Integer id){
//        orderService.deleteOrderById(id);
//        return String.format("Deleted Order #%d",id);
//    }
}
