package com.MyOnlineUsedBookStore.UsedBookStore.Controller;

import com.MyOnlineUsedBookStore.UsedBookStore.Entity.ShoppingCart;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl.ShoppingCartServiceImplementor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/shoppingCarts")
public class ShopController {

    @Autowired
    private ShoppingCartServiceImplementor shoppingCartService;

    @PostMapping
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        ShoppingCart createdShoppingCart = shoppingCartService.createShoppingCart(shoppingCart);
        return ResponseEntity.ok(createdShoppingCart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable Long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartById(id);
        shoppingCartService.updateShoppingCart(id);
        return shoppingCart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{shoppingCartId}/books/{bookId}")
    public ResponseEntity<String> addBookToCart(@PathVariable Long shoppingCartId, @PathVariable Long bookId) {
        shoppingCartService.addBookToCart(shoppingCartId, bookId);
        return ResponseEntity.ok("Book added Successfully for id : "+bookId);
    }

    @DeleteMapping("/{shoppingCartId}/books/{bookId}")
    public ResponseEntity<String> removeBookFromCart(@PathVariable Long shoppingCartId, @PathVariable Long bookId) {
        shoppingCartService.removeBookFromCart(shoppingCartId, bookId);
        return ResponseEntity.ok("Book removed Successfully for id : "+bookId);
    }
}






//import com.bookStore.MyBookStore.DTO.ShoppingCartDTO;
//import com.bookStore.MyBookStore.Entity.ShoppingCart;
//import com.bookStore.MyBookStore.Service.ServiceInterfaceImpl.ShoppingCartServiceImplementor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/shopping-cart")
//public class ShopController {
//
//    @Autowired
//    private ShoppingCartServiceImplementor shoppingCartServiceImplementor;
//
//    @GetMapping("/get-items")
//    public List<ShoppingCart> getAllCartItems(){
//        List<ShoppingCart> list = shoppingCartServiceImplementor.getAllCartItems();
//        return list;
//    }
//
//    @PostMapping("/create-item")
//    public ShoppingCartDTO createItem(@RequestBody ShoppingCartDTO shoppingCartDTO){
//        return shoppingCartServiceImplementor.createItem(shoppingCartDTO);
//    }
//
//    @PostMapping("/update-item")
//    public ShoppingCartDTO updateItem(@RequestBody ShoppingCartDTO shoppingCartDTO, Long id){
//        return  shoppingCartServiceImplementor.updateItem(shoppingCartDTO, 2L);
//    }
//
//    @PostMapping("/delete-item")
//    public ShoppingCartDTO deleteItem(@RequestBody ShoppingCartDTO shoppingCartDTO){
//        return shoppingCartServiceImplementor.deleteItem(shoppingCartDTO);
//    }
//}
