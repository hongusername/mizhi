package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usercomments {//用户评论表
    private Integer tcid;//评论编号
    private Users users;//外键 用户编号
    private String tctype;//评论类型
    private Integer parentid;//父评论id
    private String content;//评论内容
    private Integer agreecount,disagreecount;//同意量,反对量
    private Timestamp tctime;//评论时间
    private String commentstatus;//评论状态

    //外键  评论外键编号 1.文章评论 2.回答评论  3.书籍评论  4.用户动态评论
    private Answers answers;
    private Articles articles;
    private Books books;
    private Userstalks userstalks;


}
