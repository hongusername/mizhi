package cn.jishu.mizhi.hong.usercomments.services.impl;

import cn.jishu.mizhi.entity.Usercomments;
import cn.jishu.mizhi.hong.usercomments.dao.UsersCommentsMapper;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCommentsServicesImpl implements UserCommentsServices {
    @Resource
    private UsersCommentsMapper usersCommentsMapper;

    @Override
    public PageInfo<Usercomments> queryCommentsByFkid(Integer pageNum, Integer pageSize, Integer fkid, String tctype, Integer parentid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Usercomments> list = usersCommentsMapper.queryCommentsByFkid(fkid, tctype, parentid);
        PageInfo<Usercomments> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Usercomments detailUserCommentByTcid(int tcid) {
        return usersCommentsMapper.detailUserCommentByTcid(tcid);
    }
}
