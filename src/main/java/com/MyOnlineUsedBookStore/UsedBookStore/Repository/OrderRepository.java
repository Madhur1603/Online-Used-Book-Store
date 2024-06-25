package com.MyOnlineUsedBookStore.UsedBookStore.Repository;

import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
