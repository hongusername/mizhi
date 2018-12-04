package cn.jishu.mizhi.shuai.answers.dao;

import cn.jishu.mizhi.entity.Answers;

import java.util.List;

public interface AnswersDao {
    List<Answers> queryByIdAdd(Integer userid);
}
