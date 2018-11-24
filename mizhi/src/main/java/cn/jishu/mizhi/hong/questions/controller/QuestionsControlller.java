package cn.jishu.mizhi.hong.questions.controller;

import cn.jishu.mizhi.entity.Answers;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Usercomments;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionsControlller {
    @Resource
    private QuestionsServices questionsServices;
    @Resource
    private AnswersServices answersServices;
    @Resource
    private UserCommentsServices userCommentsServices;

    //跳转home主页面
    @RequestMapping("toHomeListController")
    public String toHomeList(@RequestParam(required = false, defaultValue = "1") Integer pageNum, Model model, HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        PageInfo<Questions> qpage = questionsServices.getQuestionsByQuestionType(pageNum, 1);
        List<Questions> questionsList = qpage.getList();
        for (Questions qlist : questionsList) {
            Answers a = qlist.getAnswersList().get(0);
            PageInfo<Usercomments> uclist = userCommentsServices.queryCommentsByFkid(1, a.getAwid(), "2");
            a.setUsercommentsPageInfo(uclist);
            qlist.getAnswersList().set(0, a);
        }
        qpage.setList(questionsList);
        System.out.println("qpage:" + qpage);
        model.addAttribute("qpage", qpage);
        return "Home.html";
    }

    //关注模块ajax分页
    @RequestMapping("ajaxQuestionList")
    @ResponseBody
    public PageInfo<Questions> ajaxQuestionList(Integer pageNum) {
        PageInfo<Questions> qpage = questionsServices.getQuestionsByQuestionType(pageNum, 1);
        List<Questions> questionsList = qpage.getList();
        for (Questions qlist : questionsList) {
            Answers a = qlist.getAnswersList().get(0);
            PageInfo<Usercomments> uclist = userCommentsServices.queryCommentsByFkid(1, a.getAwid(), "2");
            a.setUsercommentsPageInfo(uclist);
            qlist.getAnswersList().set(0, a);
        }
        qpage.setList(questionsList);
        System.out.println("qpage:" + qpage);
        return qpage;
    }

    @RequestMapping("detailQuestionPage")
    public String detailQuestionPage(Integer qid, Model model) {
        System.out.println("qid:"+qid);
        return "answer";
    }
}
