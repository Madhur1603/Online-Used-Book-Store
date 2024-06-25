package com.MyOnlineUsedBookStore.UsedBookStore.Repository;


import com.MyOnlineUsedBookStore.UsedBookStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
//    public User findByEmail(String email); // parameter should be same with the entity variable

//    @Query("select u from User u where u.email = ?1")
//    public User getByEmail(String email);

    @Query("select u from User u where u.f_name = ?1")
    public User getByFirstName(String f_name);

}
