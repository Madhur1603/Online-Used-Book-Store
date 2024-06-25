package com.MyOnlineUsedBookStore.UsedBookStore.Controller;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl.UserServiceImplimentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImplimentor userServiceImplimentor;

    @GetMapping("/getAll-users")
    public List<UserDTO> getAllUsers(){
        return  userServiceImplimentor.getAllUsers();
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO u = userServiceImplimentor.getUserById(id);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){ // getting the userDTO from the http request that is why we have to put request body
        UserDTO u = userServiceImplimentor.createUser(userDTO);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        UserDTO u = userServiceImplimentor.updateUser(userDTO, id);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/delete-user")
    public UserDTO deleteUser(@RequestBody UserDTO userDTO){
        return userServiceImplimentor.deleteUser(userDTO);
    }

    @DeleteMapping("/delete-allUser")
    public UserDTO deleteAllUser(){
        return userServiceImplimentor.deleteAllUser();
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userServiceImplimentor.deleteUserById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }


}
