package cn.jishu.mizhi.shuai.questions.services;

import cn.jishu.mizhi.entity.Questions;

import java.util.List;

public interface QuestionsServices {
    List<Questions> queruyByUserId(Integer userid);
}
