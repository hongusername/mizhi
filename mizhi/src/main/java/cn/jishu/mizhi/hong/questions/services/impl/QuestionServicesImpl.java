package cn.jishu.mizhi.hong.questions.services.impl;

import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.hong.questions.dao.QuestionsMapper;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServicesImpl implements QuestionsServices {


    @Resource
    private QuestionsMapper questionsMapper;

    @Override
    public PageInfo<Questions> getQuestionsByQuestionType(Integer pageNum, Integer userid) {
        PageHelper.startPage(pageNum, 6);
        List<Questions> list = questionsMapper.getQuestionsByQuestionType(userid);
        PageInfo<Questions> page = new PageInfo<Questions>(list);
        return page;
    }

    @Override
    public Questions detailQuestionsById(Integer qid) {
        return questionsMapper.detailQuestionsById(qid);
    }

    @Override
    public List<Questions> queryQuestionsByUsersids(List<Integer> userids ) {
        return questionsMapper.queryQuestionsByUsersids(userids);
    }

    @Override
    public Integer updateQuestionClickCount(Integer qid) {
        return questionsMapper.updateQuestionClickCount(qid);
    }


}
