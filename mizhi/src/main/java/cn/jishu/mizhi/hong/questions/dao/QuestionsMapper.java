package cn.jishu.mizhi.hong.questions.dao;

import cn.jishu.mizhi.entity.Questions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionsMapper {
    //按照用户的的喜好标签元素查询话题列表
    List<Questions> getQuestionsByQuestionType(Integer userid);
    //查询具体话题
    Questions detailQuestionsById(Integer qid);
    //查询关注模块的关注对象的发布的话题列表信息
    List<Questions> queryQuestionsByUsersids(@Param("userids") List<Integer>userids,@Param("jiange") Integer jiange);
}
