package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl;
import com.MyOnlineUsedBookStore.UsedBookStore.DTO.UserLoginDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.UserLogin;
import com.MyOnlineUsedBookStore.UsedBookStore.Mapper.UserLoginMapper;
import com.MyOnlineUsedBookStore.UsedBookStore.Repository.UserLoginRepository;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface.UserLoginServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImplementor implements UserLoginServiceInterface {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> getAllLogins() {
        List<UserLogin> list = userLoginRepository.findAll();
        return list;
    }

    @Override
    public UserLoginDTO createLogin(UserLoginDTO userLoginDTO) {
        UserLogin log = userLoginMapper.loginDtoToLogin(userLoginDTO);
        userLoginRepository.save(log);
        return userLoginMapper.loginToLoginDTO(log);
    }

    @Override
    public UserLoginDTO updateLogin(UserLoginDTO userLoginDTO, Long id) {
        Optional<UserLogin> existingLog = userLoginRepository.findById(id);

        if(existingLog.isPresent()){
            UserLogin updateLog = userLoginMapper.loginDtoToLogin(userLoginDTO);
            updateLog.setUserId(userLoginDTO.getUserId());
            updateLog.setEmail(userLoginDTO.getEmail());
            updateLog.setPassword(userLoginDTO.getPassword());

            userLoginRepository.save(updateLog);
            return userLoginMapper.loginToLoginDTO(updateLog);
        }
        return null;
    }

    @Override
    public UserLoginDTO deleteLogin(UserLoginDTO userLoginDTO) {
        UserLogin log = userLoginMapper.loginDtoToLogin(userLoginDTO);
        userLoginRepository.delete(log);
        return null;
    }
}
