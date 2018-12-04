package cn.jishu.mizhi.shuai.answers.services;

import cn.jishu.mizhi.entity.Answers;

import java.util.List;

public interface AnswersServices {
    List<Answers> queryByIdAdd(Integer userid);
}
