package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookrack {//用户书架表
    private Integer brid;//主键
    private Users users; //外键 书籍编号,
    private Books books;//外键 用户编号
}
