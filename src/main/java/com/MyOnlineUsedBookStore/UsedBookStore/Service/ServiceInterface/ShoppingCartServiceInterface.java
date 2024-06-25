package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface;



import com.MyOnlineUsedBookStore.UsedBookStore.Entity.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartServiceInterface {

    public ShoppingCart createShoppingCart(ShoppingCart shoppingKart);
    public Optional<ShoppingCart> getShoppingCartById(Long id);
    public void addBookToCart(Long shoppingCartId, Long bookId);
    public void removeBookFromCart(Long shoppingCartId, Long bookId);
    public ShoppingCart updateShoppingCart(Long shoppingCartId);




//    public List<ShoppingCart> getAllCartItems();
//    public ShoppingCartDTO createItem(ShoppingCartDTO shoppingCartDTO);
//    public ShoppingCartDTO updateItem(ShoppingCartDTO shoppingCartDTO, Long id);
//    public ShoppingCartDTO deleteItem(ShoppingCartDTO shoppingCartDTO);
}
