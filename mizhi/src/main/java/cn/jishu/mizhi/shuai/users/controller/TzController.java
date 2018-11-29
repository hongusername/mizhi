package cn.jishu.mizhi.shuai.users.controller;

import cn.jishu.mizhi.shuai.users.services.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TzController {
    @Resource
    private UsersServices services;

    @RequestMapping("gerenUpdateController")
    public String gerenUpdateHtml() {
        return "geren/gerenupdate.html";
    }

    @RequestMapping("bierenController")
    public String bieren(Model model) {
        model.addAttribute("buser",services.queryByBieRenId(1));
        return "bieren.html";
    }



    @RequestMapping("redirect")
    public String redirect() {
        return "redirect:/bQueryBooksAll";
    }
}
