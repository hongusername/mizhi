package cn.jishu.mizhi.kai.manager.dao;

import cn.jishu.mizhi.entity.ManagerUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-29 14:24
 **/
public interface ManagerUserDao {
    //根据后台管理员的id进行查询所有日志信息
    List<ManagerUser> queryAllManagerUser(@Param("userid") Integer mUserid);
    //管理员登录方法
    ManagerUser mLogin(@Param("username") String username,@Param("password") String password);
    //查询用户信息是否注册过
    ManagerUser mQueryByUserName(@Param("username")String username);

}
