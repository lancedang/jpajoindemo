package com.dangdang.springboot;

import com.dangdang.springboot.dao.one2one.BookDetailRepository;
import com.dangdang.springboot.dao.one2one.BookRepository;
import com.dangdang.springboot.entity.one2one.Book;
import com.dangdang.springboot.entity.one2one.BookDetail;
import com.dangdang.springboot.service.one2one.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Before
    public void before() {
        //清空所有数据
        bookDetailRepository.deleteAll();
        bookRepository.deleteAll();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("math");
        Book result = bookRepository.save(book);

        //不关联BookDetail也可以成功插入Book
        Assert.assertEquals(result.getName(), "math");
        Assert.assertNull(result.getBookDetail());

        //设置一个BookDetail，验证能否直接通过Book插入到数据库中
        BookDetail bookDetail = new BookDetail(10);
        book.setBookDetail(bookDetail);

        //直接插入Book，同时也会将上面的BookDetail插入到detail表中
        result = bookRepository.save(book);
        Assert.assertNotNull(result.getBookDetail());

        List<BookDetail> bookDetails = bookDetailRepository.findAll();
        Assert.assertEquals(1, bookDetails.size());
        Assert.assertEquals(10, bookDetails.get(0).getPageCount().intValue());

        //Book中的外键book_detail_id是否等于book_detail表中的行id
        Assert.assertEquals(result.getBookDetail().getId().intValue(), bookDetails.get(0).getId().intValue());
    }

}
