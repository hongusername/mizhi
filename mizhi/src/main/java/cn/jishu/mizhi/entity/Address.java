package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {//地址表111
    private Integer aid;//主键
    private Users users;//用户编号
    private District sheng;//省id
    private District shi;//市id
    private District xian;//县id
    private String street;//详细街道地址
}
