package com.neobis.eshop.controller;

import com.neobis.eshop.entity.UserEntity;
import com.neobis.eshop.exception.RecordNotFoundException;
import com.neobis.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public UserEntity findUserById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return userRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUserById(){
        return userRepository.findAll();
    }

    @PostMapping("/")
    public UserEntity changeUser(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @PutMapping("/{id}")
    public UserEntity saveUser(@PathVariable("id") @RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Integer id ){
        userRepository.deleteById(id);
        return String.format("Deleted User #%d", id);
    }

//    @Autowired
//    UserService userService;
//
//    @RequestMapping("/")
//    public String defaultUserEndpoint(){
//        return "Default User endpoint.";
//    }
//
//    @GetMapping("/{id}")
//    public User findUserById(@PathVariable("id") Integer id) throws Exception {
//        return userService.getUserById(id);
//    }
//
//    @PutMapping("/{id}")
//    public User saveUser(@PathVariable("id") @RequestBody User user){
//        return userService.saveUser(user);
//    }
//
//    @PostMapping("/")
//    public User changeUser(@RequestBody User user){
//        return userService.saveUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUserById(@PathVariable("id") Integer id ){
//        userService.deleteUserById(id);
//        return String.format("Deleted User #%d", id);
//    }
}
