package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.request.UserRequest;
import com.ecommerce.ecommerce.model.response.UserResponse;
import com.ecommerce.ecommerce.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);

    }
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable String id,@RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }
    @GetMapping
    public List<UserResponse> getAllUsers(){
        log.info("getAllUsers method started");
        log.info("All User have been bought:");
        return userService.getAllUsers();
    }
    @GetMapping ("/{id}")
    public UserResponse getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
       userService.deleteUser(id);
    }
    @PatchMapping("/active/{id}")
    public void activeUser(@PathVariable String id){
        userService.activeUser(id);
    }
    @PatchMapping("/deactive/{id}")
    public void deactiveUser(@PathVariable String id){
        userService.deactiveUser(id);
    }



}
