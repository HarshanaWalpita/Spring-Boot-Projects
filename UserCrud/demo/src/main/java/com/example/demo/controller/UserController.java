package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping("updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserId/{userId}")
    public UserDTO getUserByUserId(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/getUserByUserIdAndAddress/{userId}/{address}")
    public UserDTO getUserByUserIdAndAddress(@PathVariable String userId, @PathVariable String address){
        return userService.getUserByUserIdAndAddress(userId, address);
    }
}
