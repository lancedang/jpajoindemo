package com.dangdang.springboot.service.single;

import com.dangdang.springboot.dao.single.SinglePersonRepository;
import com.dangdang.springboot.entity.single.SinglePersonEntity;
import com.dangdang.springboot.query.PersonQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 单表不确定条件查询
 */
@Service
public class SinglePersonService {

    @Autowired
    private SinglePersonRepository singlePersonRepository;

    public SinglePersonEntity addPerson(SinglePersonEntity entity) {
        return singlePersonRepository.save(entity);
    }

    public List<SinglePersonEntity> findPersonByName(String name) {
        return singlePersonRepository.findOneByName(name);
    }

    //单表不确定条件查询
    public List<SinglePersonEntity> findPersonByCondition(PersonQuery personQuery) {

        List<Predicate> predicates = new ArrayList<>();

        Specification<SinglePersonEntity> specification = new Specification<SinglePersonEntity>() {
            @Override
            public Predicate toPredicate(Root<SinglePersonEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                //若为true,则添加判断条件
                if (personQuery.getName() != null)
                    predicates.add(cb.equal(root.get("name"), personQuery.getName()));

                if (personQuery.getGender() != null)
                    predicates.add(cb.equal(root.get("gender"), personQuery.getGender()));

                Predicate[] predicateArray = new Predicate[predicates.size()];

                predicates.toArray(predicateArray);

                Predicate predicate = cb.and(predicateArray);
                return predicate;
            }
        };

        //构造参数，硬编码查询第一页
        PageRequest pageRequest = new PageRequest(0, 10);

        Page<SinglePersonEntity> entityPage = singlePersonRepository.findAll(specification, pageRequest);

        return entityPage.getContent();
    }


}
