package cn.jishu.mizhi.hong.carequestions.services.impl;

import cn.jishu.mizhi.entity.Carequestions;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.carequestions.dao.CareQuestionsMapper;
import cn.jishu.mizhi.hong.carequestions.services.CareQuestionsServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CareQuestionsServicesImpl implements CareQuestionsServices {
    @Resource
    private CareQuestionsMapper careQuestionsMapper;

    @Override
    public Carequestions detailCarequestions(Integer userid, Integer qid) {
        return careQuestionsMapper.detailCarequestions(userid, qid);
    }

    @Override
    public Integer addQuestion(Integer userid, Integer qid) {
        return careQuestionsMapper.addQuestion(userid, qid);
    }

    @Override
    public Integer deleteQuestion(Integer userid, Integer qid) {
        return careQuestionsMapper.deleteQuestion(userid, qid);
    }

    @Override
    public PageInfo<Users> queryUsersByCares(Integer pageNum, Integer qid) {
        PageHelper.startPage(pageNum, 8);
        List<Users> list = careQuestionsMapper.queryUsersByCares(qid);
        PageInfo<Users> page = new PageInfo<Users>(list);
        return page;
    }
}
