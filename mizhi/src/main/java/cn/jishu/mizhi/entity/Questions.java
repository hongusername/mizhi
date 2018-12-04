package cn.jishu.mizhi.entity;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questions {//话题表
    private Integer qid;//主键
    private String qttitle;//话题标题
    private String qcontent;//话题内容
    private Integer clickcount;//点击量
    private String questionstatus;//话题状态
    private Users users;//用户编号,
    private List<Questionscontext> questionscontextList;
    private List<Questionstype> questionstypes;
    private List<Answers> answersList;
    private List<Carequestions> carequestions;
    private List<Answers> answers;
    private Timestamp qtime;
}
