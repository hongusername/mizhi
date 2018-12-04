package cn.jishu.mizhi.hong.questionstype.services.impl;

import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Questionstype;
import cn.jishu.mizhi.hong.questionstype.dao.QuestionsTypeMapper;
import cn.jishu.mizhi.hong.questionstype.services.QuestionsTypeServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionsTypeServicesImpl implements QuestionsTypeServices {
    @Resource
    private QuestionsTypeMapper questionsTypeMapper;


    @Override
    public List<Questionstype> queryTypeByQid(Integer qid) {
        return questionsTypeMapper.queryTypeByQid(qid);
    }

    @Override
    public List<Questionstype> queryAllQuestionsType() {
        return questionsTypeMapper.queryAllQuestionsType();
    }

    @Override
    public Integer isChooseQuestionsType(Integer userid) {
        return questionsTypeMapper.isChooseQuestionsType(userid);
    }

    @Override
    public Integer addUsersQuestionsType(int qtid, int userid) {
        return questionsTypeMapper.addUsersQuestionsTytpe(qtid,userid);
    }
}
