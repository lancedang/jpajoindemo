package com.dangdang.springboot.entity.one2one;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
@Table(name = "book", schema = "jpa")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    //JoinColumn 表明Book 是主表, book table 包含外键
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id") //book 表中定义的外键 column 列名
    private BookDetail bookDetail;

    public Book(){

    }

    public Book(String name){
        this.name = name;
    }

    //注意这些有参构造函数
    public Book(String name, BookDetail bookDetail){
        this.name = name;
        this.bookDetail = bookDetail;
    }

    //这个 toString 注意那个地方
    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, name='%s', number of pages='%d']",
                id, name, bookDetail.getPageCount());
    }

}
