package com.MyOnlineUsedBookStore.UsedBookStore.DTO;

import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCartDTO {

    private Long cart_id;
    private Long total_price = 0L;
    private int quantity;
    private Set<Book> books;

}
