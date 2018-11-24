package cn.jishu.mizhi.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {//会员表
    private Integer mid;//主键
    private String mlevel;//会员等级 1.青铜 2.白银 3.黄金
    private Integer downloadcount,scores;//可下载资源数，赠送积分数
    private double mprice,discount;//单价 一个月的价格,购物打折度
}
