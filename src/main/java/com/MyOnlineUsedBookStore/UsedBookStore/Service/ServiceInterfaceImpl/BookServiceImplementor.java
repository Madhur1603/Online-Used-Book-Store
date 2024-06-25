package com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterfaceImpl;

import com.MyOnlineUsedBookStore.UsedBookStore.DTO.BookDTO;
import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;
import com.MyOnlineUsedBookStore.UsedBookStore.Mapper.BookMapper;
import com.MyOnlineUsedBookStore.UsedBookStore.Repository.BookRepository;
import com.MyOnlineUsedBookStore.UsedBookStore.Service.ServiceInterface.BookServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementor implements BookServiceInterface {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        List<Book> listBook = bookRepository.findAll();
        return listBook;
    }

    @Override
    public BookDTO createNewBook(BookDTO bookDTO){
        Book b = bookMapper.bookDtoToBook(bookDTO);
        bookRepository.save(b);
        return bookMapper.BookToBookDTO(b);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long id){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            Book updateBook = bookMapper.bookDtoToBook(bookDTO);


            updateBook.setBookName(bookDTO.getBookName());
            updateBook.setBook_img(bookDTO.getBook_img());
            updateBook.setAuthor(bookDTO.getAuthor());
            updateBook.setPrice(bookDTO.getPrice());
            updateBook.setBook_url(bookDTO.getBook_url());
            updateBook.setRating(bookDTO.getRating());
            updateBook.setGenre(bookDTO.getGenre());

            bookRepository.save(updateBook);
            return bookMapper.BookToBookDTO(updateBook);
        }
        return null;
    }

    @Override
    public BookDTO deleteBook(BookDTO bookDTO){
        Book b = bookMapper.bookDtoToBook(bookDTO);
        bookRepository.delete(b);
        return null;
    }

    @Override
    public BookDTO deleteAllBooks() {
        bookRepository.deleteAll();
        return null;
    }

    @Override
    public Set<BookDTO> getBooksByGenre(String genre) {
        Set<Book> bookSet = bookRepository.findByGenre(genre);
        return bookSet.stream().map((b)->bookMapper.BookToBookDTO(b)).collect(Collectors.toSet());
    }
}
