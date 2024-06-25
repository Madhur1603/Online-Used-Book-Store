package com.MyOnlineUsedBookStore.UsedBookStore.DTO;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {

    private Long orderId;
    private Date date;
    private Date expectedDelivery;
    private String paymentType;

}
