package com.dangdang.springboot;

import com.dangdang.springboot.dao.BookRepository;
import com.dangdang.springboot.entity.Book;
import com.dangdang.springboot.entity.BookDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.tools.jar.CommandLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
@Slf4j
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = new ArrayList<>();

        books.add(new Book("A", new BookDetail(10)));
        books.add(new Book("B", new BookDetail(20)));
        books.add(new Book("C", new BookDetail(30)));

        bookRepository.save(books);

        //fetch all book
        for (Book book : bookRepository.findAll()) {
            log.info(book.toString());
        }
    }
}
