package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.OrderDTO;


import java.util.List;

public interface OrderServiceInterface {

    public List<OrderDTO> getAllOrders();
    public OrderDTO getOrderById(Long id);
    public OrderDTO createOrder(OrderDTO orderDTO);
    public OrderDTO updateOrder(OrderDTO orderDTO, Long id);
    public OrderDTO deleteOrderById(Long id);
    public OrderDTO deleteAllOrders();
}
