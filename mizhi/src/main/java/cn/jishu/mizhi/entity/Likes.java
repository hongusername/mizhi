package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likes {//收藏表
    private Integer lid;//收藏编号
    private Users users;//用户编号
    private String lname;//收藏名称
    private List<Likecontexts> likecontextsList;
}
