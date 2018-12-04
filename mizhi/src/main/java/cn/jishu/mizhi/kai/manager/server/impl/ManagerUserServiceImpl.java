package cn.jishu.mizhi.kai.manager.server.impl;

import cn.jishu.mizhi.entity.ManagerController;
import cn.jishu.mizhi.entity.ManagerUser;
import cn.jishu.mizhi.kai.manager.dao.ManagerDao;
import cn.jishu.mizhi.kai.manager.dao.ManagerUserDao;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import cn.jishu.mizhi.kai.manager.server.ManagerUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-29 14:35
 **/
@Service
public class ManagerUserServiceImpl implements ManagerUserService{
    @Resource
    private ManagerUserDao managerUserDao;
    @Override
    public List<ManagerUser> queryAllManagerUser(Integer mUserid) {
        return managerUserDao.queryAllManagerUser(mUserid);
    }

    @Override
    public ManagerUser mLogin(String username, String password) {
        return managerUserDao.mLogin(username,password);
    }

    @Override
    public ManagerUser mQueryByUserName(String username) {
        return managerUserDao.mQueryByUserName(username);
    }

    @Override
    public List<ManagerController> mCdate(Integer sessionId) {
        return managerUserDao.mCdate(sessionId);
    }

    @Override
    public List<ManagerController> mContext(String rzTime) {
        return managerUserDao.mContext(rzTime);
    }
}
