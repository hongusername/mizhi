package cn.jishu.mizhi.shuai.users.services.impl;

import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.shuai.users.dao.UsersDao;
import cn.jishu.mizhi.shuai.users.services.UsersServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersServicesImpl implements UsersServices {


    @Resource
    private UsersDao dao;

    @Override
    public Users usersLogin(Users users) {
        return dao.usersLogin(users);
    }

    @Override
    public List<Users> queryAll() {
        return dao.queryAll();
    }

    @Override
    public Integer userAdd(Users user) {
        return dao.userAdd(user);
    }

    @Override
    public Users queryPhoneYN(String phone) {
        return dao.queryPhoneYN(phone);
    }

    @Override
    public Integer updatePassword(Users user) {
        return dao.updatePassword(user);
    }

    @Override
    public Users phoneLogin(String phone) {
        return dao.phoneLogin(phone);
    }

    @Override
    public Integer updateBj(Users users) {
        return dao.updateBj(users);
    }

    @Override
    public Integer updateTouxiang(Users users) {
        return dao.updateTouxiang(users);
    }

    @Override
    public Integer updateUser(Users user) {
        return dao.updateUser(user);
    }
}
