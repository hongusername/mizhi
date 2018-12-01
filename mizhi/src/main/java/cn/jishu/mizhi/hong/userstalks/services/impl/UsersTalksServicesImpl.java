package cn.jishu.mizhi.hong.userstalks.services.impl;

import cn.jishu.mizhi.entity.Userstalks;
import cn.jishu.mizhi.hong.userstalks.dao.UsersTalksMapper;
import cn.jishu.mizhi.hong.userstalks.services.UsersTalksServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UsersTalksServicesImpl implements UsersTalksServices {
    @Resource
    private UsersTalksMapper usersTalksMapper;

    @Override
    public List<Userstalks> queryUserTalksByuserids(List<Integer> userids ) {
        return usersTalksMapper.queryUserTalksByuserids(userids);
    }
}
