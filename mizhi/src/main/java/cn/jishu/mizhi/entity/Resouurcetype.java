package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resouurcetype {//资源类型表
    private Integer rtid;//主键
    private String rtname;//资源类型
    private List<Resources> resourceses;
}
