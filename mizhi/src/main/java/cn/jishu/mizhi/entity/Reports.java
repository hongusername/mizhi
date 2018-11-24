package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reports {

    private Integer rid;//编号
    private Users users;//用户编号
    private String rtype;//举报类型  1.文章操作  2.回答操作  3.动态操作  4.评论操作
    private String rstatus;//举报状态
    private Timestamp rtime;//发起举报时间
    private Integer fkid;//外键
}
