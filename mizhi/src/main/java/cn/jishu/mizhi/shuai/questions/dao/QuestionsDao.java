package cn.jishu.mizhi.shuai.questions.dao;

import cn.jishu.mizhi.entity.Questions;

import java.util.List;

public interface QuestionsDao {
     List<Questions> queruyByUserId(Integer userid);
}
