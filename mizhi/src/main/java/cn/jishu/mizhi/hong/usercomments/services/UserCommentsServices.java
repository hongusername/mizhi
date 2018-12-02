package cn.jishu.mizhi.hong.usercomments.services;

import cn.jishu.mizhi.entity.Usercomments;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserCommentsServices {

    //查询特定回答下所有的评论信息
    PageInfo<Usercomments> queryCommentsByFkid(Integer pageNum, Integer fkid, String tctype);
}
