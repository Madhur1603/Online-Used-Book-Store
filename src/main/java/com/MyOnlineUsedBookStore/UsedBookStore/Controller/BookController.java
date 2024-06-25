package com.MyOnlineUsedBookStore.UsedBookStore.Controller;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.BookDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl.BookServiceImplementor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImplementor bookServiceImplementor;

    @GetMapping("/get-books")
    public List<Book> getAllBooks(){
        List<Book> list = bookServiceImplementor.getAllBooks();
        return list;
    }

    @PostMapping("/create-book")
    public BookDTO createNewBook(@RequestBody BookDTO bookDTO){
        return bookServiceImplementor.createNewBook(bookDTO);
    }

    @DeleteMapping("/delete-book")
    public BookDTO deleteBook(@RequestBody BookDTO bookDTO){
        return bookServiceImplementor.deleteBook(bookDTO);
    }

    @DeleteMapping("/delete-allBook")
    public BookDTO deleteAllBooks(){
        return bookServiceImplementor.deleteAllBooks();
    }

    @PutMapping("/update-book/{id}")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO,@PathVariable Long id){
        return bookServiceImplementor.updateBook(bookDTO, id);
    }

    @GetMapping("/get-book/{genre}")
    public Set<BookDTO> getBooksByGenre(@PathVariable String genre){
        Set<BookDTO> set = bookServiceImplementor.getBooksByGenre(genre);
        return set;
    }
}
