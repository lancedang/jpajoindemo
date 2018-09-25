package com.dangdang.springboot.dao.one2one;

import com.dangdang.springboot.entity.one2one.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepository extends JpaRepository<BookDetail, Integer>{

}
