package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface;



import com.MyOnlineUsedBookStore.UsedBookStore.DTO.BookDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;

import java.util.*;

public interface BookServiceInterface {
     public List<Book> getAllBooks();
     public BookDTO createNewBook(BookDTO bookDTO);
     public BookDTO updateBook(BookDTO bookDTO, Long id);
     public BookDTO deleteBook(BookDTO bookDTO);
     public BookDTO deleteAllBooks();

     public Set<BookDTO> getBooksByGenre(String genre);
}
