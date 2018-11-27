package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {//用户表
    private Integer userid;//用户编号
    private String password,phone,email,gender,nickname;//密码，手机号，邮箱，性别，昵称
    private Timestamp regtime;//注册日期
    private Date birthday;//出生日期
    private String introduce;//个人介绍
    private Integer clickcount,level,userscore;//主页浏览数,用户等级,用户积分
    private String headimg,homepageimg,ustatus;//用户头像,用户主页背景,用户状态
    private List<Address> addressList;
    private List<Resources> resourcesList;
    private List<Userdownloads> userdownloadsList;
    private List<Cares> caresList;
    private List<News> newsList;
    private List<Usermember> usermemberList;
    private List<Bookrack> bookrackList;
    private List<Orderform> orderformList;
    private List<Likes> likesList;
    private List<Articles> articlesList;
    private List<Questions> questionsList;
    private List<Answers> answersList;
    private List<Usercomments> usercommentsList;
    private List<UserQuestionTypes> userQuestionTypesList;

}
