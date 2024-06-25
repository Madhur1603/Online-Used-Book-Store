package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.User;
import com.MyOnlineUsedBookStore.UsedBookStore.ExceptionHandler.ResourceNotFoundException;
import com.MyOnlineUsedBookStore.UsedBookStore.Mapper.UserMapper;
import com.MyOnlineUsedBookStore.UsedBookStore.Repository.UserRepository;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplimentor implements UserServiceInterface {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> listUser = userRepo.findAll();
        return listUser.stream().map((user)-> userMapper.userToUserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User u = userRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User does not exist for given id" +id)
        );
        return userMapper.userToUserDTO(u);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        userRepo.save(user);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {

        User existingUser = userRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist for given id" + id)
        );

        existingUser.setF_name(userDTO.getF_name());
        existingUser.setL_name(userDTO.getL_name());
        existingUser.setUserName(userDTO.getUserName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());

        userRepo.save(existingUser);
        return userMapper.userToUserDTO(existingUser);
    }
        // we have written entity in <> as only the entity can react with database and in this we are checking if the user exist for that particular id.
//        Optional<User> existingUser = userRepo.findById(id);
        // if existing user is having any value
//        if(existingUser.isPresent()){
//            // we first convert thr DTO to Entity
//            User updateUser = userMapper.userDtoToUser(userDTO);
//            // Do the updation task on it
//            updateUser.setUserId(userDTO.getUserId());
//            updateUser.setF_name(userDTO.getF_name());
//            updateUser.setL_name(userDTO.getL_name());
//            updateUser.setUserName(userDTO.getUserName());
//            updateUser.setEmail(userDTO.getEmail());
//            updateUser.setPassword(userDTO.getPassword());
//            // save it in the repository
//            userRepo.save(updateUser);
//            // again convert the entity to DTO to send the response
//            return userMapper.userToUserDTO(updateUser);
//        }


    @Override
    public UserDTO deleteUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        userRepo.delete(user);
        return null;
    }

    @Override
    public UserDTO deleteAllUser() {
        userRepo.deleteAll();
        return null;
    }

    @Override
    public UserDTO deleteUserById(Long id) {
        User u = userRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User does not exist with this id " +id)
        );
        userRepo.delete(u);
        return userMapper.userToUserDTO(u);
    }


}
