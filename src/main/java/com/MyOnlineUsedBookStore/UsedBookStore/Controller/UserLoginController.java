package com.MyOnlineUsedBookStore.UsedBookStore.Controller;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserLoginDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.UserLogin;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl.UserLoginServiceImplementor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private UserLoginServiceImplementor userLoginServiceImplementor;

    @GetMapping("/get-logins")
    public List<UserLogin> getAllLogins(){
        List<UserLogin> list = userLoginServiceImplementor.getAllLogins();
        return list;
    }

    @PostMapping("/create-login")
    public UserLoginDTO createLogin(@RequestBody UserLoginDTO userLoginDTO){
        return userLoginServiceImplementor.createLogin(userLoginDTO);
    }

    @PostMapping("/update-login")
    public UserLoginDTO updateLogin(@RequestBody UserLoginDTO userLoginDTO, Long id){
        return userLoginServiceImplementor.updateLogin(userLoginDTO, 2L);
    }

    @PostMapping("/delete-login")
    public UserLoginDTO deleteLogin(@RequestBody UserLoginDTO userLoginDTO){
        return userLoginServiceImplementor.deleteLogin(userLoginDTO);
    }
}
