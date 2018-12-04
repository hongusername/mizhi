package cn.jishu.mizhi.hong.answers.dao;

import cn.jishu.mizhi.entity.Answers;
import cn.jishu.mizhi.entity.Questions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswersMapper {
    //查询指定话题下的回答列表
    List<Answers> queryAnswersByQid(Integer qid);
    //查询关注模块的关注对象的发布的话题列表信息
    List<Answers> queryAnswersByUsersids(@Param("userids") List<Integer> userids);

}
