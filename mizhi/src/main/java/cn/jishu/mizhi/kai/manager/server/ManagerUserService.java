package cn.jishu.mizhi.kai.manager.server;

import cn.jishu.mizhi.entity.ManagerController;
import cn.jishu.mizhi.entity.ManagerUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-29 14:34
 **/
public interface ManagerUserService {
    //根据后台管理员的id进行查询所有日志信息
    List<ManagerUser> queryAllManagerUser(Integer mUserid);
    //管理员登录方法
    ManagerUser mLogin(String username,String password);
    //查询用户信息是否注册过
    ManagerUser mQueryByUserName(@Param("username")String username);
    //根据后台管理员的id查询对应日期
    List<ManagerController> mCdate(Integer sessionId);
    //根据sessionid查出来的事件去进行查询日志
    List<ManagerController> mContext(@Param("rzTime")String rzTime);
    //根据情况进行插入日志信息
    Integer insertContext(@Param("rzContext")ManagerController managerController);
}
