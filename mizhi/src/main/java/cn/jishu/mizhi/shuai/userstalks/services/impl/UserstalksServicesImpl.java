package cn.jishu.mizhi.shuai.userstalks.services.impl;

import cn.jishu.mizhi.entity.Userstalks;
import cn.jishu.mizhi.shuai.userstalks.dao.UserstalksDao;
import cn.jishu.mizhi.shuai.userstalks.services.UserstalksServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserstalksServicesImpl implements UserstalksServices {
    @Resource
    private UserstalksDao dao;
    @Override
    public List<Userstalks> queryByUserId(Integer userid) {
        return dao.queryByUserId(userid);
    }
}
