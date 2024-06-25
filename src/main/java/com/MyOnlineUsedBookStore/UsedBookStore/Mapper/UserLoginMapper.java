package com.MyOnlineUsedBookStore.UsedBookStore.Mapper;


import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserLoginDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.UserLogin;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserLoginDTO loginToLoginDTO(UserLogin userLogin){
        UserLoginDTO uld = modelMapper.map(userLogin, UserLoginDTO.class);
        return uld;
    }

    public UserLogin loginDtoToLogin(UserLoginDTO userLoginDTO){
        UserLogin ul = modelMapper.map(userLoginDTO, UserLogin.class);
        return ul;
    }
}
