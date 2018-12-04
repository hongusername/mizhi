package cn.jishu.mizhi.hong.carequestions.dao;

import cn.jishu.mizhi.entity.Carequestions;
import cn.jishu.mizhi.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CareQuestionsMapper {

    //查看用户是否关注问题
    Carequestions detailCarequestions(@Param("userid") Integer userid, @Param("qid") Integer qid);

    //用户关注问题
    Integer addQuestion(@Param("userid") Integer userid, @Param("qid") Integer qid);

    //取消关注问题
    Integer deleteQuestion(@Param("userid") Integer userid, @Param("qid") Integer qid);

    //关注问题的用户列表
    List<Users> queryUsersByCares(Integer qid);
}
