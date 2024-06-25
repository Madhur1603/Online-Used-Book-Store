package com.MyOnlineUsedBookStore.UsedBookStore.Mapper;
import com.MyOnlineUsedBookStore.UsedBookStore.DTO.BookDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Book bookDtoToBook(BookDTO bookDTO){
        Book b = modelMapper.map(bookDTO, Book.class);
        return b;
    }

    public BookDTO BookToBookDTO(Book book){
        BookDTO bdto = modelMapper.map(book, BookDTO.class);
        return bdto;
    }
}
