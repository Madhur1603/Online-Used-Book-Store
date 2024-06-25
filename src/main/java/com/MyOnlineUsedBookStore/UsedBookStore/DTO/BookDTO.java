package com.MyOnlineUsedBookStore.UsedBookStore.DTO;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

    private Long book_id;
    private String book_img;
    private String bookName;
    private String author;
    private Long price;
    private String genre;
    private String book_url;
    private double rating;


}
