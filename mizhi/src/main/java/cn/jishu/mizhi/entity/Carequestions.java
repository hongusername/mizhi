package cn.jishu.mizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carequestions {//收藏话题表
    private Integer cqid;//关注话题编号
    private Users users;//用户编号
    private Questions questions;//话题编号
}
