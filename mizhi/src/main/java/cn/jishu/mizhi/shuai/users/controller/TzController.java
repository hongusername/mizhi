package cn.jishu.mizhi.shuai.users.controller;

import cn.jishu.mizhi.entity.*;
import cn.jishu.mizhi.shuai.answers.services.AnswersServices;
import cn.jishu.mizhi.shuai.articles.services.ArticlesServicess;
import cn.jishu.mizhi.shuai.cares.services.CaresServicess;
import cn.jishu.mizhi.shuai.questions.services.QuestionsServices;
import cn.jishu.mizhi.shuai.users.services.UsersServices;
import cn.jishu.mizhi.shuai.userstalks.services.UserstalksServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TzController {
    @Resource
    private UsersServices services;
    @Resource
    private QuestionsServices qservices;
    @Resource
    private UserstalksServices uservices;
    @Resource
    private AnswersServices aservices;
    @Resource
    private ArticlesServicess rservices;
    @Resource
    private CaresServicess cservices;

    @RequestMapping("gerenUpdateController")
    public String gerenUpdateHtml() {
        return "geren/gerenupdate.html";
    }


    @RequestMapping("bieren")
    public String bieren(Integer userid, Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            return "userLogin.html";
        }
        if (userid == null) {
            return "redirect:/geren";
        }
        if (userid == user.getUserid()) {
            return "redirect:/geren";
        }
        model.addAttribute("buser", services.queryByBieRenId(userid));
        List<Questions> tiwen = qservices.queruyByUserId(userid);
        model.addAttribute("tiwen", tiwen);
        List<Userstalks> dongtai = uservices.queryByUserId(userid);
        model.addAttribute("dongtai", dongtai);
        List<Answers> huida = aservices.queryByIdAdd(userid);
        model.addAttribute("huida", huida);
        List<Articles> wenzhang = rservices.queryAll(userid);
        model.addAttribute("wenzhang", wenzhang);
        List<Cares> gzwdr = cservices.queryAllGzwdr(userid);
        model.addAttribute("gzwdr", gzwdr.size());
        List<Cares> wgzdr = cservices.queryAllWgzdr(userid);
        model.addAttribute("wgzdr", wgzdr.size());
        List<Cares> thisGz = cservices.queryAllWgzdr(user.getUserid());
        model.addAttribute("thisGz", thisGz);
        return "bieren.html";
    }


    @RequestMapping("geren")
    public String geren(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "userLogin.html";
        }
        Users user = (Users) session.getAttribute("user");
        model.addAttribute("buser", services.queryByBieRenId(user.getUserid()));
        List<Questions> tiwen = qservices.queruyByUserId(user.getUserid());
        model.addAttribute("tiwen", tiwen);
        List<Userstalks> dongtai = uservices.queryByUserId(user.getUserid());
        model.addAttribute("dongtai", dongtai);
        List<Answers> huida = aservices.queryByIdAdd(user.getUserid());
        model.addAttribute("huida", huida);
        List<Articles> wenzhang = rservices.queryAll(user.getUserid());
        model.addAttribute("wenzhang", wenzhang);
        List<Cares> gzwdr = cservices.queryAllGzwdr(user.getUserid());
        model.addAttribute("gzwdr", gzwdr.size());
        List<Cares> wgzdr = cservices.queryAllWgzdr(user.getUserid());
        model.addAttribute("wgzdr", wgzdr.size());
        return "geren.html";
    }

    @RequestMapping("guanzhuwoderen")
    public String guanzhuwode(Integer userid, Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        List<Cares> gzwdr = cservices.queryAllGzwdr(userid);
        model.addAttribute("list", gzwdr);
        List<Cares> thisGz = cservices.queryAllWgzdr(user.getUserid());
        model.addAttribute("thisGz", thisGz);
        return "geren/gz.html";
    }

    @RequestMapping("woguanzhuderen")
    public String woguanzhuderen(Integer userid, Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        List<Cares> wgzdr = cservices.queryAllWgzdr(userid);
        for (Cares c : wgzdr) {
            Users u = services.queryPhoneYN(c.getCareuser().getPhone());
            c.setCareuser(u);
        }
        model.addAttribute("list", wgzdr);
        List<Cares> thisGz = cservices.queryAllWgzdr(user.getUserid());
        model.addAttribute("thisGz", thisGz);
        return "geren/gz.html";
    }

    @RequestMapping("redirect")
    public String redirect() {
        return "redirect:/geren";
    }
}
