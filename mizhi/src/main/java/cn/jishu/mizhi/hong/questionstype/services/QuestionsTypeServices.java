package cn.jishu.mizhi.hong.questionstype.services;

import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Questionstype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionsTypeServices {

    //查询某个话题所属的标签
    List<Questionstype> queryTypeByQid(Integer qid);

    //查询全部话题标签
    List<Questionstype> queryAllQuestionsType();

    //查询指定用户是否有选择话题标签
    Integer isChooseQuestionsType(Integer userid);

    //批量增加
    Integer addUsersQuestionsType(@Param("qids") int qtid, @Param("userid") int userid);
}
