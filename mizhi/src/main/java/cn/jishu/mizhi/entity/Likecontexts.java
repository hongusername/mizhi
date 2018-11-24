package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likecontexts {//收藏内容表
    private Integer lcid;//收藏内容编号
    private Likes likes;//外键 收藏编号
    private String lctype;//收藏类型 1.文章 2.回答
    private Articles articles;//,收藏外键编号
    private Questions questions;
}

