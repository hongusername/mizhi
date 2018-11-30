package cn.jishu.mizhi.shuai.userstalks.dao;

import cn.jishu.mizhi.entity.Userstalks;

import java.util.List;

public interface UserstalksDao {
    List<Userstalks> queryByUserId(Integer userid);
}
