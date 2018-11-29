package cn.jishu.mizhi.shuai.users.controller;

import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.shuai.users.services.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String yzm(String phone) {
        return "200107";
    }

    @RequestMapping("zhuceController")
    @ResponseBody
    public boolean zhuce(Users user) {
        Integer t = services.userAdd(user);
        if (t == 1) {
            return true;
        } else {
            return false;
        }

    }

    @RequestMapping("queryPhone")
    @ResponseBody
    public boolean queryPhone(String phone) {
        Users user = services.queryPhoneYN(phone);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("updatePwd")
    @ResponseBody
    public boolean updatePwd(Users user) {
        Integer i = services.updatePassword(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("phoneLogin")
    @ResponseBody
    public boolean phoneLogin(String phone, HttpSession session) {
        Users user = services.phoneLogin(phone);
        if (user != null) {
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }



    @RequestMapping("updateUserController")
    @ResponseBody
    public boolean update(Users user, HttpSession session, String asdasd) {
        if (asdasd != null && asdasd != "") {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(sdf.parse(asdasd));
            } catch (ParseException e) {
                System.out.print("日期格式出错");
            }
        }
        Users users = (Users) session.getAttribute("user");
        user.setUserid(users.getUserid());
        Integer u = services.updateUser(user);
        session.setAttribute("user", services.phoneLogin(users.getPhone()));
        return (u > 0);
    }
}
