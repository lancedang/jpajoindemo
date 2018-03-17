package demo.service;

import demo.dao.UserInfoRepository;
import demo.entity.GroupUserEntity;
import demo.entity.UserGroupQuery;
import demo.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public Page<UserInfoEntity> findUserByCondition(UserGroupQuery userGroupQuery) {

        Specification<UserInfoEntity> userSpecification = new Specification<UserInfoEntity>() {
            @Override
            public Predicate toPredicate(Root<UserInfoEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate namePredicate = cb.like(root.get("userName").as(String.class), "%"+ userGroupQuery.getUserName()+ "%");
                Join<UserInfoEntity, GroupUserEntity> join = root.join(root.getModel().getSingularAttribute("groupUser", GroupUserEntity.class), JoinType.INNER);
                Predicate groupIdPredicate = cb.equal(join.get("groupId").as(Long.class), userGroupQuery.getGroupId());

                query.where(cb.and(namePredicate, groupIdPredicate));

                return query.getRestriction();
            }
        };

        Pageable pageable = new PageRequest(0, 10);
        //Page<UserInfoEntity> userInfoEntities = userInfoRepository.findAll(userSpecification, pageable);

        return null;
    }

}
