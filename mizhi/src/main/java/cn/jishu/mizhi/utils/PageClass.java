package cn.jishu.mizhi.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageClass {

    private Integer pageNum;
    private List<Object> objectList;
}
