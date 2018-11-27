package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderform {//订单表
    private Integer dfid;//主键
    private Users users;//外键 用户编号
    private Books books;//外键 书籍编号
    private Timestamp ofgettime, ofovertime;//订单提交时间,订单完成时间
    private String ofstatus;//订单状态 1.正常 0.撤销
    private double ofprice;//订单价格
}
