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
@NamedQuery(
        name="Book.findByGenre",
        query = "select b from Book b where b.genre = :genre"
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    @Column
    private String book_img;
    @Column
    private String bookName;
    @Column
    private String author;
    @Column
    private Long price;
    @Column
    private String genre;
    @Column
    private String book_url;
    @Column
    private double rating;





    // Book is an independent entity hence it will not have any reference of other entities tables
    // but other entities may have the reference of the book entity table

}
