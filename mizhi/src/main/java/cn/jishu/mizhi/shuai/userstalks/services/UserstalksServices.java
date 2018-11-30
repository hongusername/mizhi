package cn.jishu.mizhi.shuai.userstalks.services;

import cn.jishu.mizhi.entity.Userstalks;

import java.util.List;

public interface UserstalksServices {
    List<Userstalks> queryByUserId(Integer userid);
}
