package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdownloads {//用户下载表
    private Integer udid;//主键
    private Users users;//外键,用户编号,
    private Resources resources;//外键 资源编号
}
