package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionstype {//话题标签表
    private Integer qtid;//主键
    private String qtname;//话题标签名称
}
