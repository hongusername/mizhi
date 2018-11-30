package cn.jishu.mizhi.shuai.questions.services.impl;

import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.shuai.questions.dao.QuestionsDao;
import cn.jishu.mizhi.shuai.questions.services.QuestionsServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionsServicesImpl implements QuestionsServices {
    @Resource
    private QuestionsDao dao;

    @Override
    public List<Questions> queruyByUserId(Integer userid) {
        return dao.queruyByUserId(userid);
    }
}
