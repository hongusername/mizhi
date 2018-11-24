package cn.jishu.mizhi.hong.answers.services.impl;

import cn.jishu.mizhi.entity.Answers;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.answers.dao.AnswersMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswersServicesImpl implements AnswersServices {
    @Resource
    private AnswersMapper answersMapper;

    @Override
    public PageInfo<Answers> queryAnswersByQid(Integer pageNum, Integer qid) {
        PageHelper.startPage(pageNum, 5);
        List<Answers> list = answersMapper.queryAnswersByQid(qid);
        PageInfo<Answers> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<Questions> queryAnswersByUsersids(List<Integer> userids, Integer jiange) {
        return answersMapper.queryAnswersByUsersids(userids,jiange);
    }
}
