package com.MyOnlineUsedBookStore.UsedBookStore.Configurations;


import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ProjectConfigs {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UserServiceImplimentor userServiceImplimentor(){
        return new UserServiceImplimentor();
    }

    @Bean
    public BookServiceImplementor bookServiceImplementor(){
        return new BookServiceImplementor();
    }

    @Bean
    public ShoppingCartServiceImplementor shoppingCartServiceImplementor(){
        return new ShoppingCartServiceImplementor();
    }

    @Bean
    public UserLoginServiceImplementor userLoginServiceImplementor(){
        return new UserLoginServiceImplementor();
    }

    @Bean
    public OrderServiceImplementor orderServiceImplementor(){
        return new OrderServiceImplementor();
    }
}
