package cn.jishu.mizhi.hong.cares.services;

import cn.jishu.mizhi.entity.Cares;
import cn.jishu.mizhi.entity.Users;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaresServices {

    //根据用户id获取所关注的用户id集合
    List<Cares> getAllCaresId(Integer userid);

    //根据指定用户id和被关注者id查询信息
    Integer queryCountByCares(Integer userid, Integer becardid);

    //关注用户
    Integer addCaresByUsers(Integer userid, Integer becardid);

    //取消关注
    Integer deleteCaresByUsers(Integer userid, Integer becardid);
    //查询某用户的粉丝
    PageInfo<Users> queryAllByBecardid(Integer pageNum, Integer becardid);
}
