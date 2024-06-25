package com.MyOnlineUsedBookStore.UsedBookStore.Repository;

import com.MyOnlineUsedBookStore.UsedBookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface BookRepository extends JpaRepository<Book, Long > {

    public Set<Book> findByGenre(@Param("genre") String genre);

}
//    public List<Book> findByPriceGreaterThan(Long price);
