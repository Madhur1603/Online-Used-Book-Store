package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserDTO;


import java.util.List;

public interface UserServiceInterface {

    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Long id);
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO updateUser(UserDTO userDTO, Long id);
    public UserDTO deleteUser(UserDTO userDTO);
    public UserDTO deleteAllUser();
    public UserDTO deleteUserById(Long id);

}
