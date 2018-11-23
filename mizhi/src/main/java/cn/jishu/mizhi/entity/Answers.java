package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answers {//话题回答表
    private Integer awid;//编号
    private Users users;//外键 用户编号
    private String awcontent;//评论内容
    private Timestamp awtime;//回答时间
    private Integer agreecount, ducagreecount;//同意量,反对量
    private String isNi, awstatus;//是否匿名评论,回答状态
    private Questions questions;//外键 话题编号
    private String isuse;//是否被采用 0没有 1采用
    private List<Usercomments> usercommentsList;

}
