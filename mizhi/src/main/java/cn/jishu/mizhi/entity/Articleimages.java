package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articleimages {//文章图片表
    private Integer aiid;//文章图片编号
    private Articles articles; //外键 文章编号
    private String articleimage;//文章图片路径
}
