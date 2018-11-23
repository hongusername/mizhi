package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userstalks {//用户动态表
    private Integer utid;//用户动态编号
    private Users users;
    private String utcontent;//用户动态内容
    private Integer praisecount,clickcount;//点赞数,点击数
    private Timestamp talktime;//发布动态时间
    private List<Usercomments> usercommentsList;
    private String utstatus;//用户状态

}
