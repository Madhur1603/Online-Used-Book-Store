package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface;


import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserLoginDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.UserLogin;

import java.util.List;

public interface UserLoginServiceInterface {
    public List<UserLogin> getAllLogins();
    public UserLoginDTO createLogin(UserLoginDTO userLoginDTO);
    public UserLoginDTO updateLogin(UserLoginDTO userLoginDTO, Long id);
    public UserLoginDTO deleteLogin(UserLoginDTO userLoginDTO);
}
