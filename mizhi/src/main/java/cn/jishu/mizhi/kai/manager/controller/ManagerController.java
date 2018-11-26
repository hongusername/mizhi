package cn.jishu.mizhi.kai.manager.controller;

import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

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
   @RequestMapping("ManagerController")
    public String toDengLu(){
        return "017/index";
    }

    @RequestMapping("UserTable")
    public String userTable(Map map){
       map.put("userAll",managerService.queryAllUser());
       return "017/profile";
    }

    @RequestMapping("queryByUserId")
    @ResponseBody
    public Users queryByid(Integer id){
        System.out.println(id);
       Users user=managerService.qeuryUsersById(id);
        System.out.println(user.getUserid());
       return user;
    }

    @RequestMapping("qeuryQuestion")
    public String queryByAllQuestion(Map map){
       map.put("questionAll",managerService.qeuryAllQuestions());

       return "017/pricing";
    }

    @RequestMapping("queryAllMamber")
    public String queryAllMember(Map map){
       map.put("memberAll",managerService.queryAll());
       return "017/invoice";
    }

}
