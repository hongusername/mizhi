package cn.jishu.mizhi.kai.manager.controller;

import cn.jishu.mizhi.entity.Member;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public List<Object> queryByid(Integer id){
        System.out.println(id);
        Users user=managerService.qeuryUsersById(id);
        System.out.println(user);
        Date date=new Date();
        date=user.getBirthday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date2=format.format(date);
        System.out.println(date2);
        List<Object> list=new ArrayList<>();
        list.add(0,user);
        list.add(1,date2);
       return list;
    }
    @RequestMapping("queryQuestionType")
    @ResponseBody
    public List<Questions> queryById(Integer id, Map map){
        System.out.println(id);
        System.out.println(managerService.queyrTypeById(id));
       return managerService.queyrTypeById(id);
    }

    @RequestMapping("qeuryMemberById")
    @ResponseBody
    public Member queryByMemberId(Integer id){
       Member member=managerService.queryByMemberById(id);
       return member;
    }

    @RequestMapping("qeuryQuestion")
    public String queryByAllQuestion(Map map){
       map.put("questionAll",managerService.qeuryAllQuestions());
        System.out.println(managerService.qeuryAllQuestions());
       return "017/pricing";
    }

    @RequestMapping("queryAllMamber")
    public String queryAllMember(Map map){
       map.put("memberAll",managerService.queryAll());
       return "017/invoice";
    }
    @RequestMapping("deleteByMemberById")
    public String deleteByQuestionId(Integer id){
        System.out.println(id);
       managerService.deleteByQuestionId(id);
        System.out.println(managerService.deleteByQuestionId(id));
       return  "forward:queryAllMamber";

    }

}
