package com.MyOnlineUsedBookStore.UsedBookStore.Repository;


import com.MyOnlineUsedBookStore.UsedBookStore.Entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

}
