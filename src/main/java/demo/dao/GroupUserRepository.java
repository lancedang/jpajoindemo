package demo.dao;

import demo.entity.GroupUserEntity;
import demo.entity.UserInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupUserRepository extends JpaRepository<GroupUserEntity, Long> {

    Page<GroupUserEntity> findAll(Specification<GroupUserEntity> specification, Pageable pageable);

    //注意 where 子句的写法
    @Query("select a from GroupUserEntity a where a.userInfo.userId=?1")
    GroupUserEntity  findGroupUserByUserId(Long userId);

    //对于update 语句, 重新调用 save(Entity) 方法, 不要用 update, 针对where以 userInfo.** 这种条件作为判断的情况
}
