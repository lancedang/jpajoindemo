package com.dangdang.springboot.entity.one2one;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_detail", schema = "jpa")
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "page_count")
    private Integer pageCount;

    //标记 java 中属性, mappedBy 表明 book_detail 表为从表
    //@OneToOne(mappedBy = "bookDetail")
    //private Book book;

    public BookDetail(){

    }

    public BookDetail(Integer numberOfPages){
        this.pageCount = numberOfPages;
    }

}
