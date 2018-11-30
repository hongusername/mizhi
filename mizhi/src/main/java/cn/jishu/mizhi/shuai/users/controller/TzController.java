package cn.jishu.mizhi.shuai.users.controller;

import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Userstalks;
import cn.jishu.mizhi.shuai.questions.services.QuestionsServices;
import cn.jishu.mizhi.shuai.users.services.UsersServices;
import cn.jishu.mizhi.shuai.userstalks.services.UserstalksServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TzController {
    @Resource
    private UsersServices services;
    @Resource
    private QuestionsServices qservices;
    @Resource
    private UserstalksServices uservices;

    @RequestMapping("gerenUpdateController")
    public String gerenUpdateHtml() {
        return "geren/gerenupdate.html";
    }

    @RequestMapping("bierenController")
    public String bieren(Model model) {
        model.addAttribute("buser", services.queryByBieRenId(1));
        List<Questions> wenzhang = qservices.queruyByUserId(1);
        model.addAttribute("wenzhang", wenzhang);
        List<Userstalks> dongtai = uservices.queryByUserId(1);
        model.addAttribute("dongtai", dongtai);
        return "bieren.html";
    }


    @RequestMapping("redirect")
    public String redirect() {
        return "geren.html";
    }
}
