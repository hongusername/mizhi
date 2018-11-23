package cn.jishu.mizhi.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {//私信用户表
    private Integer nid;//信息编号
    private String ncontent;//信息内容
    private Timestamp sendtime;//发送时间
    private String newstatus;//信息状态 1.正常 2.撤销
    private Users senduser;
    private Users besenduser;
    private String isread;//信息是否被读取 0:没有 1.被读取



}
