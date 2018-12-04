package cn.jishu.mizhi.hong.questionstype;

import cn.jishu.mizhi.entity.Questionstype;
import cn.jishu.mizhi.hong.questionstype.services.QuestionsTypeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.ListIterator;

@Controller
public class QuestionsTypeController {
    @Resource
    private QuestionsTypeServices questionsTypeServices;

    @RequestMapping("toQuestionsTypePageController")
    public String toQuestionTypePage(Model model, int[] qtids) {
        List<Questionstype> questionstypeList = questionsTypeServices.queryAllQuestionsType();
        model.addAttribute("qtidsitem",qtids);
        model.addAttribute("questionstypeList", questionstypeList);
        return "questionstypepage";
    }




}
