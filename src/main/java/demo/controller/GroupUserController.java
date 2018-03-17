package demo.controller;

import demo.entity.GroupUserEntity;
import demo.entity.UserGroupQuery;
import demo.entity.UserInfoEntity;
import demo.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupUserController {

    @Autowired
    GroupUserService groupUserService;

    @RequestMapping(value = "/condition", method = RequestMethod.GET)
    public Page<GroupUserEntity> getUserByCondition(UserGroupQuery userGroupQuery) {
        Page<GroupUserEntity> groupUserEntities = groupUserService.findGroupUserByCondition(userGroupQuery);
        return groupUserEntities;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<GroupUserEntity> getAllGroupUsers() {
        return groupUserService.findAllGroupUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public GroupUserEntity getAllGroupUsers(@RequestParam Long userId) {
        return groupUserService.findGroupUserByUserId(userId);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public GroupUserEntity addNewGroupUser(@RequestParam Long groupId, @RequestBody UserInfoEntity userInfoEntity) {
        return groupUserService.addGroupUser(groupId, userInfoEntity);
    }

}
