package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuestionTypes {

    private Integer uqtid;
    private Users users;
    private  Questionstype questionstype;

}
