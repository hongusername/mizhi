package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionscontext {//话题回答中间表
    private Integer qcid;//主键
    private Questions questions;//外键 话题编号,
    private Questionstype questionstype;//外键 话题标签编号
}
