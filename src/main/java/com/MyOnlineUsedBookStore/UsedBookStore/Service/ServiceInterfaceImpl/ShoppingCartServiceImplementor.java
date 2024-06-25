package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl;

import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.ShoppingCart;
import com.MyOnlineUsedBookStore.UsedBookStore.ExceptionHandler.ResourceNotFoundException;
import com.MyOnlineUsedBookStore.UsedBookStore.Repository.BookRepository;
import com.MyOnlineUsedBookStore.UsedBookStore.Repository.ShoppingCartRepository;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface.ShoppingCartServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImplementor implements ShoppingCartServiceInterface {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private BookRepository bookRepository;

    public ShoppingCart createShoppingCart(ShoppingCart shoppingKart) {
        return shoppingCartRepository.save(shoppingKart);
    }

    public Optional<ShoppingCart> getShoppingCartById(Long id) {
        return shoppingCartRepository.findById(id);
    }

    public void addBookToCart(Long shoppingCartId, Long bookId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new RuntimeException("ShoppingCart not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        shoppingCart.addBook(book);
        shoppingCartRepository.save(shoppingCart);
    }

    public void removeBookFromCart(Long shoppingCartId, Long bookId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new RuntimeException("ShoppingCart not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        shoppingCart.removeBook(book);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart updateShoppingCart(Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow(() -> new ResourceNotFoundException("Shopping Cart not Found"));
        Long sum = 0L;
        for(Book b : shoppingCart.allBooks()){
            sum = sum + b.getPrice();
        }
        shoppingCart.setTotal_price(sum);
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }
}





