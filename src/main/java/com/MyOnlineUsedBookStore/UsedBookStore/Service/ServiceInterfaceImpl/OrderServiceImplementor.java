package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl;
import com.MyOnlineUsedBookStore.UsedBookStore.DTO.OrderDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Order;
import com.MyOnlineUsedBookStore.UsedBookStore.ExceptionHandler.ResourceNotFoundException;
import com.MyOnlineUsedBookStore.UsedBookStore.Mapper.OrderMapper;
import com.MyOnlineUsedBookStore.UsedBookStore.Repository.OrderRepository;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface.OrderServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImplementor implements OrderServiceInterface {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> list = orderRepository.findAll();
        return list.stream().map((o)->orderMapper.orderToOrderDTO(o)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order o = orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No Order exist for this id")
        );

        return orderMapper.orderToOrderDTO(o);
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order o = orderMapper.orderDtoToOrder(orderDTO);
        orderRepository.save(o);
        return orderMapper.orderToOrderDTO(o);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, Long id) {
        Order o = orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No Order exist for this id")
        );

        o.setDate(orderDTO.getDate());
        o.setExpectedDelivery(orderDTO.getExpectedDelivery());
        o.setPaymentType(orderDTO.getPaymentType());

        orderRepository.save(o);

        return orderMapper.orderToOrderDTO(o);
    }

    @Override
    public OrderDTO deleteOrderById(Long id) {
        Order o = orderRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("No Order exist for this id")
        );
        orderRepository.delete(o);
        return orderMapper.orderToOrderDTO(o);
    }

    @Override
    public OrderDTO deleteAllOrders() {
        orderRepository.deleteAll();
        return null;
    }
}
