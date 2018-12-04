package cn.jishu.mizhi.hong.cares.dao;

import cn.jishu.mizhi.entity.Cares;
import cn.jishu.mizhi.entity.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaresMapper {

//根据用户id获取所关注的用户id集合
    List<Cares> getAllCaresId(Integer userid);
    //根据指定用户id和被关注者id查询信息
    Integer queryCountByCares(@Param("userid") Integer userid, @Param("becardid") Integer becardid);
    //关注用户
    Integer addCaresByUsers(@Param("userid") Integer userid, @Param("becardid") Integer becardid);
    //取消关注
    Integer deleteCaresByUsers(@Param("userid") Integer userid, @Param("becardid") Integer becardid);
    //查询某用户的粉丝
    List<Users> queryAllByBecardid(Integer becardid);
}
