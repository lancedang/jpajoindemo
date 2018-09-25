package com.dangdang.springboot.service.one2one;

import com.dangdang.springboot.dao.one2one.BookRepository;
import com.dangdang.springboot.entity.one2one.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
