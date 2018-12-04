package cn.jishu.mizhi.hong.carequestions.services;

import cn.jishu.mizhi.entity.Carequestions;
import cn.jishu.mizhi.entity.Users;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CareQuestionsServices {

    //查看用户是否关注问题
    Carequestions detailCarequestions(Integer userid, Integer qid);

    //用户关注问题
    Integer addQuestion(Integer userid, Integer qid);

    //取消关注问题
    Integer deleteQuestion(Integer userid, Integer qid);
    //关注问题的用户列表
    PageInfo<Users> queryUsersByCares(Integer pageNum, Integer qid);
}
