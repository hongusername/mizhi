package cn.jishu.mizhi.hong.answers.services;

import cn.jishu.mizhi.entity.Answers;
import cn.jishu.mizhi.entity.Questions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswersServices {

    PageInfo<Answers> queryAnswersByQid(Integer pageNum,Integer qid);

    //查询关注模块的关注对象的发布的话题列表信息
    List<Answers> queryAnswersByUsersids(@Param("userids") List<Integer>userids);
}
