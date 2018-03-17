package demo.service;

import demo.dao.GroupUserRepository;
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
import java.util.List;

@Service
public class GroupUserService {

    @Autowired
    private GroupUserRepository groupUserRepository;

    public Page<GroupUserEntity> findGroupUserByCondition(UserGroupQuery userGroupQuery) {

        Specification<GroupUserEntity> userSpecification = new Specification<GroupUserEntity>() {
            @Override
            public Predicate toPredicate(Root<GroupUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                //匹配 groupId
                Predicate namePredicate = cb.equal(root.get("groupId").as(Long.class), userGroupQuery.getGroupId());
                Join<GroupUserEntity, UserInfoEntity> join = root.join(root.getModel().getSingularAttribute("userInfo", UserInfoEntity.class), JoinType.INNER);

                Predicate groupIdPredicate = cb.like(join.get("userName").as(String.class), "%" +userGroupQuery.getUserName()+"%");

                query.where(cb.and(namePredicate, groupIdPredicate));

                return query.getRestriction();
            }
        };

        Pageable pageable = new PageRequest(0, 10);
        Page<GroupUserEntity> groupUserEntities = groupUserRepository.findAll(userSpecification, pageable);

        return groupUserEntities;
    }

    public List<GroupUserEntity> findAllGroupUsers() {
        return groupUserRepository.findAll();
    }

    public GroupUserEntity findGroupUserByUserId(Long userId) {
        return groupUserRepository.findGroupUserByUserId(userId);
    }

    public GroupUserEntity addGroupUser(Long groupId, UserInfoEntity userInfoEntity) {
        GroupUserEntity groupUserEntity = new GroupUserEntity();
        groupUserEntity.setGroupId(groupId);
        groupUserEntity.setUserInfo(userInfoEntity);
        return groupUserRepository.save(groupUserEntity);
    }

}
