package cn.jishu.mizhi.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles {//文章表
    private Integer articleid;//主键
    private Users users;//外键 用户编号
    private Articletype articletype;//外键 文章类型编号,
    private String atitle;//文章标题
    private String acontent;//文章内容
    private Integer clickcount,agreecount,disagreecount;//浏览量,赞同量,反对量
    private String articlestatus;//文章状态 1.正常 2.撤销
    private Timestamp articletime;//文章发表时间
    private Integer rewardscore,rewardcount;//打赏总积分,打赏总次数
    private List<Articleimages> articleimagesList;
    private List<Userstalks> userstalksList;


}
