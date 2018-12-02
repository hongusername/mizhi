package cn.jishu.mizhi.hong;

import cn.jishu.mizhi.entity.Questionstype;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.questionstype.services.QuestionsTypeServices;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {
    @Resource
    private QuestionsTypeServices questionsTypeServices;

   /* @RequestMapping("/aController")
    public String a(Model model) {
        Users users = new Users();
        users.setUserid(1);
            Integer result = questionsTypeServices.isChooseQuestionsType(users.getUserid());
            if(result==0){
                System.out.println("yes");
                List<Questionstype> questionstypeList = questionsTypeServices.queryAllQuestionsType();
                model.addAttribute("questionstypeList",questionstypeList);
                return  "first";
            }else{
                System.out.println("no");
                return "forward:/toHomeListController";
            }
        }*/

}
