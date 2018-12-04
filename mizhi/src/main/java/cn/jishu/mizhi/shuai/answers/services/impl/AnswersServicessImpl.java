package cn.jishu.mizhi.shuai.answers.services.impl;

import cn.jishu.mizhi.entity.Answers;
import cn.jishu.mizhi.shuai.answers.dao.AnswersDao;
import cn.jishu.mizhi.shuai.answers.services.AnswersServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswersServicessImpl implements AnswersServices {
    @Resource
    private AnswersDao dao;

    @Override
    public List<Answers> queryByIdAdd(Integer userid) {
        return dao.queryByIdAdd(userid);
    }
}
