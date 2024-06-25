package com.MyOnlineUsedBookStore.UsedBookStore.Controller;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.OrderDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl.OrderServiceImplementor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImplementor orderServiceImplementor;

    @GetMapping("/get-allOrder")
    public List<OrderDTO> getAllOrders(){
        List<OrderDTO> list = orderServiceImplementor.getAllOrders();
        return list;
    }

    @GetMapping("/get-order/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        OrderDTO o = orderServiceImplementor.getOrderById(id);
        return ResponseEntity.ok(o);
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        OrderDTO o = orderServiceImplementor.createOrder(orderDTO);
        return new ResponseEntity<>(o, HttpStatus.CREATED);
    }

    @PutMapping("/update-order/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable Long id){
        OrderDTO o = orderServiceImplementor.updateOrder(orderDTO, id);
        return ResponseEntity.ok(o);
    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id){
        orderServiceImplementor.deleteOrderById(id);
        return ResponseEntity.ok("Successfully Deleted order id: "+id);
    }

    @DeleteMapping("/delete-allOrders")
    public ResponseEntity<String> deleteAllOrders(){
        orderServiceImplementor.deleteAllOrders();
        return ResponseEntity.ok("All orders deleted successfully");
    }

}
