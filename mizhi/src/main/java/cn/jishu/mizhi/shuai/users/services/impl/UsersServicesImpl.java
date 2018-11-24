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
}
