package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookstar {//星级评价表
   private Integer  btid ;//主键
    private Users users;//用户编号
    private Userstalks userstalks;//评论编号
    private Integer startcount;//星级评价



}
