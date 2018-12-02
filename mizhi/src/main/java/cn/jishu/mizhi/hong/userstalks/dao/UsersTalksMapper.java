package cn.jishu.mizhi.hong.userstalks.dao;

import cn.jishu.mizhi.entity.Userstalks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersTalksMapper {

    //查询关注模块中的用户动态列表
    List<Userstalks> queryUserTalksByuserids(@Param("userids") List<Integer> userids);

}
