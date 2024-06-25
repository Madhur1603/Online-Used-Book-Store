package com.MyOnlineUsedBookStore.UsedBookStore.Mapper;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.ShoppingCartDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.ShoppingCart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCart shopDtoToShop(ShoppingCartDTO shoppingCartDTO){
        ShoppingCart sc = modelMapper.map(shoppingCartDTO, ShoppingCart.class);
        return sc;
    }

    public ShoppingCartDTO shopToShopDTO(ShoppingCart shoppingCart){
        ShoppingCartDTO scd = modelMapper.map(shoppingCart, ShoppingCartDTO.class);
        return scd;
    }

}
