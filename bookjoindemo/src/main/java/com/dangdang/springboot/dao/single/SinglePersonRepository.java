package com.dangdang.springboot.dao.single;

import com.dangdang.springboot.entity.single.SinglePersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinglePersonRepository extends JpaRepository<SinglePersonEntity, Integer> {
    //不确定条件查询
    Page<SinglePersonEntity> findAll(Specification specification, Pageable pageable);
}
