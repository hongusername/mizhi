package cn.jishu.mizhi.shuai.users.dao;

import cn.jishu.mizhi.entity.Users;

import java.util.List;

public interface UsersDao {
    //手机号邮箱登录
    Users usersLogin(Users users);
    List<Users> queryAll();
    Integer userAdd(Users user);
}
