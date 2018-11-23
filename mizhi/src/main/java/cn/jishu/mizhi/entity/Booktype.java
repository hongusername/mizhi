package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booktype {//书籍类型表
    private Integer btid;//主键
    private String btname;//书籍类型
    private List<Books> booksList;
}
