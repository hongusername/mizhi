package cn.jishu.mizhi.shuai.cares.controller;

import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.shuai.cares.services.CaresServicess;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CaresController {
    @Resource
    private CaresServicess services;

    @RequestMapping("guanzhu")
    @ResponseBody
    public boolean guanzhu(Integer id, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        Integer r = services.guanzhu(user.getUserid(), id);
        return (r > 0);
    }

    @RequestMapping("quxiao")
    @ResponseBody
    public boolean quxiao(Integer id, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        Integer r = services.quxiao(user.getUserid(), id);
        return (r > 0);
    }
}
