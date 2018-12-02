package cn.jishu.mizhi.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cares {//关注用户表
    private Integer careid;//主键
    private Users careuser;
    private Users becareuser;
    private Integer becardid;

}
