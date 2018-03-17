package com.dangdang.springboot.dao;

import com.dangdang.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
