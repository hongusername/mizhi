package cn.jishu.mizhi.kai.manager.controller;

import cn.jishu.mizhi.kai.manager.server.ManagerService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-24 17:25
 **/
@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;
    /**
     * @Description: 用户方法
     * @Param: []
     * @return: java.util.List<cn.jishu.mizhi.entity.Users>
     * @Author: ShiDunKai
     * @Date: 2018/11/23
     */
   /* List<Users> queryAllUser();
    Users qeuryUsersById(@Param("userId") Integer userid);
    Integer updateUserStatus(@Param("updateUser") Users users);*/


}
