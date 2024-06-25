package com.MyOnlineUsedBookStore.UsedBookStore.Repository;

import com.MyOnlineUsedBookStore.UsedBookStore.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
