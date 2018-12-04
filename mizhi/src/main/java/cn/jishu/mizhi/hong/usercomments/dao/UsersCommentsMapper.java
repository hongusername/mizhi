package cn.jishu.mizhi.hong.usercomments.dao;

import cn.jishu.mizhi.entity.Usercomments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersCommentsMapper {
    //查询特定回答下所有的评论信息
    List<Usercomments> queryCommentsByFkid(@Param("fkid") Integer fkid, @Param("tctype") String tctype,@Param("parentid")Integer parentid);
    //查询出某条具体的评论
    Usercomments detailUserCommentByTcid(int tcid);

}
