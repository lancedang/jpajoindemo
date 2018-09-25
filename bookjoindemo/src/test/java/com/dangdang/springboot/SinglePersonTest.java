package com.dangdang.springboot;

import com.dangdang.springboot.entity.single.SinglePersonEntity;
import com.dangdang.springboot.query.PersonQuery;
import com.dangdang.springboot.service.single.SinglePersonService;
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
public class SinglePersonTest {

    @Autowired
    private SinglePersonService singlePersonService;

    @Before
    public void before() {
        SinglePersonEntity p1 = new SinglePersonEntity("zhangsan", "boy");
        SinglePersonEntity p2 = new SinglePersonEntity("zhangsan", "girl");
        SinglePersonEntity p3 = new SinglePersonEntity("lisi", "boy");

        singlePersonService.addPerson(p1);
        singlePersonService.addPerson(p2);
        singlePersonService.addPerson(p3);
    }

    //确定条件查询
    @Test
    public void testFindPerson() {
        String name = "zhangsan";
        List<SinglePersonEntity> persons = singlePersonService.findPersonByName(name);
        Assert.assertEquals(2, persons.size());
    }

    //不确定条件查询
    @Test
    public void testFindPersonByCondition() {
        //构造查询参数
        PersonQuery personQuery = new PersonQuery();
        //personQuery.setName("");
        //personQuery.setGender("boy");

        List<SinglePersonEntity> persons = singlePersonService.findPersonByCondition(personQuery);
        Assert.assertEquals(3, persons.size());
    }

}
