package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {//区域表
    private Integer id;
    private String name;
    private Integer parent_id;
    private String initial;
    private String initials,pinyin,extra,suffix;
    private String code;
    private String area_code;
    private Integer order;
}
