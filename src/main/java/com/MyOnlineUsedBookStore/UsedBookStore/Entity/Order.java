package com.MyOnlineUsedBookStore.UsedBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    @UpdateTimestamp
    private Date date;
    @Column
    private Date expectedDelivery;
    @Column
    private String paymentType;
}
