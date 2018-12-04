package cn.jishu.mizhi.hong.userstalks.services;

import cn.jishu.mizhi.entity.Userstalks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersTalksServices {

    //查询关注模块中的用户动态列表
    List<Userstalks> queryUserTalksByuserids(List<Integer> userids);

}
