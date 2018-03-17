package com.dangdang.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_detail")
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "page_count")
    private Integer pageCount;

    //标记 java 中属性, mappedBy 表明 book_detail 表为从表
    @OneToOne(mappedBy = "bookDetail")
    private Book book;

    public BookDetail(){

    }

    public BookDetail(Integer numberOfPages){
        this.pageCount = numberOfPages;
    }

}
