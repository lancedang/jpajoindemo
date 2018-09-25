package com.dangdang.springboot.dao.one2one;

import com.dangdang.springboot.entity.one2one.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
