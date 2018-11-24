package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articletype {//文章类型
    private Integer articletypeid;//文章类型编号
    private String articletypename;//文章类型名称
    private List<Articles> articleses;
}
