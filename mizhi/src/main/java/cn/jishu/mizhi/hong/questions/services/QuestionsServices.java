package cn.jishu.mizhi.hong.questions.services;

import cn.jishu.mizhi.entity.Questions;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionsServices {
    //按照用户的的喜好标签元素查询话题列表
    PageInfo<Questions> getQuestionsByQuestionType(Integer PageNum, Integer userid);
    //查询具体话题
    Questions detailQuestionsById(Integer qid);

    //查询关注模块的关注对象的发布的话题列表信息
    List<Questions> queryQuestionsByUsersids( List<Integer>userids,Integer jiange);
}
