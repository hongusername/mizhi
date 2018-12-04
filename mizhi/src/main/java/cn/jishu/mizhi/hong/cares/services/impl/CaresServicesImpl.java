package cn.jishu.mizhi.hong.cares.services.impl;

import cn.jishu.mizhi.entity.Cares;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.cares.dao.CaresMapper;
import cn.jishu.mizhi.hong.cares.services.CaresServices;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CaresServicesImpl implements CaresServices {
    @Resource
    private CaresMapper caresMapper;

    @Override
    public List<Cares> getAllCaresId(Integer userid) {
        return caresMapper.getAllCaresId(userid);
    }

    @Override
    public Integer queryCountByCares(Integer userid, Integer becardid) {
        return caresMapper.queryCountByCares(userid,becardid);
    }

    @Override
    public Integer addCaresByUsers(Integer userid, Integer becardid) {
        return caresMapper.addCaresByUsers(userid,becardid);
    }

    @Override
    public Integer deleteCaresByUsers(Integer userid, Integer becardid) {
        return caresMapper.deleteCaresByUsers(userid,becardid);
    }

    @Override
    public PageInfo<Users> queryAllByBecardid(Integer pageNum,Integer becardid) {
        PageHelper.startPage(pageNum,8);
        List<Users> list = caresMapper.queryAllByBecardid(becardid);
        PageInfo<Users> page = new PageInfo<Users>(list);
        return page;
    }
}
