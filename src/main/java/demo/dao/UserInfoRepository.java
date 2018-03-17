package demo.dao;

import demo.entity.GroupUserEntity;
import demo.entity.UserInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<GroupUserEntity, Long> {

    Page<GroupUserEntity> findAll(Specification<GroupUserEntity> specification, Pageable pageable);

}
