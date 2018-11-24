package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operations {//赞踩状态表
    private Integer aid;//主键
    private Users users;//用户编号
    private String atype;//操作类型  1.文章操作  2.回答操作  3.动态操作  4.评论操作
    private String astatus;
    private Timestamp atime;//操作时间
    private Userstalks userstalks;//外键编号
    private Articles articles;
    private Usercomments usercomments;
    private Answers answers;
}
