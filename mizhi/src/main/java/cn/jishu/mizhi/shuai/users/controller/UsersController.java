package cn.jishu.mizhi.shuai.users.controller;

import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.shuai.users.services.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {
    @Resource
    private UsersServices services;
    @RequestMapping("userLoginController")
    @ResponseBody
    public boolean login(Users users, HttpSession session) {
        Users user = services.usersLogin(users);
        if (user == null) {
            return false;
        } else {
            session.setAttribute("user", user);
            return true;
        }
    }
    @RequestMapping("yzmController")
    @ResponseBody
    public String yzm(String phone){
        return phone;
    }
}
