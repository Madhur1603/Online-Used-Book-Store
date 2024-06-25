package com.MyOnlineUsedBookStore.UsedBookStore.Mapper;


import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public User userDtoToUser(UserDTO userDTO){
        // modelMapper.map(takenObject, return type class) this convert the object to the other class bytes stream
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }

    public UserDTO userToUserDTO(User users){
        UserDTO userDto = modelMapper.map(users,UserDTO.class);
        return userDto;
    }

}
