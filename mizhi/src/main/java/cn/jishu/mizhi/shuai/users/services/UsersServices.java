package cn.jishu.mizhi.shuai.users.services;

import cn.jishu.mizhi.entity.Users;

import java.util.List;

public interface UsersServices {
    //手机号邮箱登录
    Users usersLogin(Users users);

    List<Users> queryAll();

    Integer userAdd(Users user);
}
