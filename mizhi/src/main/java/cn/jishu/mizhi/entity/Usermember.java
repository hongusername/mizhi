package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usermember {//用户会员表
    private Integer umid;//主键
    private Integer umembertime;//外键,用户编号,外键 会员类型编号,用户会员时常
    private double umprice;//总价
    private Integer umrcount;//会员可剩余资源下载数
    private Timestamp buytime, pasttime;//购买日期,过期日期
    private Integer remain;//剩余时常
    private String umstatus;//会员状态 1.使用中 2.过期
    private Member member;
    private Users users;
}

