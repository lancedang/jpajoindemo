##### join 说明
- 外层 module 是 user-group demo
- 内层是 book-book_detail demo

##### 区别
- book 表中是对 book_detail 表持有 外键引用的
- book Entity和 book_detail Entity 是双向关联, 即两个Entity 都有 @onetoone 字段
- book 表在通过 java 对象插入的时候, 会**同时插入 book_detail row 到 detail 表中**
- 且插入顺序：现插入一个 book_detail 再插入一个 book row, 因为 插入book 需要知道外键 book_detail_id 
    - Hibernate: insert into book_detail (page_count) values (?)
    - Hibernate: insert into book (book_detail_id, name) values (?, ?)
    - Hibernate: insert into book_detail (page_count) values (?)
    - Hibernate: insert into book (book_detail_id, name) values (?, ?)
    - Hibernate: insert into book_detail (page_count) values (?)
    - Hibernate: insert into book (book_detail_id, name) values (?, ?)
  
##### 参考
- https://hellokoding.com/jpa-one-to-one-foreignkey-relationship-example-with-spring-boot-maven-and-mysql/

##### 后期任务
- 去掉数据库 foreign 尝试
- 顺带插入 book_detail 要了解
- CascadeType.ALL 