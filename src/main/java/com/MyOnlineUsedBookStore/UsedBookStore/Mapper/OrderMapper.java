package com.MyOnlineUsedBookStore.UsedBookStore.Mapper;
import com.MyOnlineUsedBookStore.UsedBookStore.DTO.OrderDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO orderToOrderDTO(Order order){
        OrderDTO o = modelMapper.map(order,OrderDTO.class);
        return o;
    }

    public Order orderDtoToOrder(OrderDTO orderDTO){
        Order o = modelMapper.map(orderDTO, Order.class);
        return o;
    }
}
