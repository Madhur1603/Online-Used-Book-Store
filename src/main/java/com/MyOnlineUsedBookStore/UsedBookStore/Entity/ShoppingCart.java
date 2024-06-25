package com.MyOnlineUsedBookStore.UsedBookStore.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;
    @Column
    private Long total_price = 0L;
    @Column
    private int quantity;

    @OneToMany
    @JoinTable(
            name="shoppingCart_books",
            joinColumns = @JoinColumn(name="c_id"), inverseJoinColumns = @JoinColumn(name="b_id")
    )
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public Set<Book> allBooks(){
        return books;
    }

}
