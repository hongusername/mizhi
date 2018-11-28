package cn.jishu.mizhi.shuai.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TzController {
    @RequestMapping("gerenUpdateController")
    public String gerenUpdateHtml(){
        return "geren/gerenupdate.html";
    }

}
