package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.ls.LSInput;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {//书籍表
    private Integer bid;//主键
    private Booktype booktype; //书籍类型编号
    private String bname, author, title, description;//书籍名称,作者,标题,前言
    private Timestamp createtime;//上架时间
    private String bookstatus;//书籍状态 1.上架 2.下架 3.无货
    private Integer aggreecount;//赞成量
    private double oldprice, newprice;//原价，现价
    private String tryread;//试读部分
    private String bookspath;//书籍路径
    private Integer avgstarcount;//书籍平星级评分;
    private List<Usercomments> usercommentsList;
    private List<Userstalks> userstalksList;
}
