package cn.jishu.mizhi.hong.questions.controller;

import cn.jishu.mizhi.entity.*;
import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.carequestions.services.CareQuestionsServices;
import cn.jishu.mizhi.hong.cares.services.CaresServices;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import cn.jishu.mizhi.hong.questionstype.services.QuestionsTypeServices;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import cn.jishu.mizhi.hong.userstalks.services.UsersTalksServices;
import cn.jishu.mizhi.utils.ComparatorConfig;
import cn.jishu.mizhi.utils.PageClass;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.boot.webservices.client.HttpWebServiceMessageSenderBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class QuestionsController {
    @Resource
    private QuestionsServices questionsServices;
    @Resource
    private AnswersServices answersServices;
    @Resource
    private UserCommentsServices userCommentsServices;
    @Resource
    private QuestionsTypeServices questionsTypeServices;
    @Resource
    private CaresServices caresServices;

    @Resource
    private UsersTalksServices usersTalksServices;
    @Resource
    private CareQuestionsServices careQuestionsServices;



    @RequestMapping("/addUsersQuestionsTypeController")
    public String addUsersQuestionsType(int[] qids, HttpSession session) {
        //Users users = (Users) session.getAttribute("user");
        Users user = new Users();
        user.setUserid(1);
        for(int i = 0;i<qids.length;i++){
            questionsTypeServices.addUsersQuestionsType(qids[i],user.getUserid());
        }
        return "forward:/toHomeListController";
    }


    //跳转home主页面
    @RequestMapping("toHomeListController")
    public String toHomeList(@RequestParam(required = false, defaultValue = "1") Integer pageNum, Model model, HttpSession session) {

        return "Home";
    }

    //跳转home的推荐模块页面
    @RequestMapping("toRecommendListController")
    public String tocresList(@RequestParam(required = false, defaultValue = "1") Integer pageNum, Model model, HttpSession session) {
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
        return "recommend";
    }


    @RequestMapping("toCaresListController")
    public String toCaresList() {
        return "care";
    }


    //推荐模块ajax加载
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

    //查看具体问题的信息
    @RequestMapping("detailQuestionPage")
    public String detailQuestionPage(Integer qid, Model model, @RequestParam(required = false, defaultValue = "1") Integer pageNum, HttpSession session) {
        //  Users users = (Users) session.getAttribute("user");
        Users users = new Users();
        users.setUserid(1);
        Questions question = questionsServices.detailQuestionsById(qid);
        List<Questionstype> questionstypeList = questionsTypeServices.queryTypeByQid(qid);
        PageInfo<Answers> answersPageInfo = answersServices.queryAnswersByQid(pageNum, qid);
        List<Answers> answersList = answersPageInfo.getList();
        for (Answers answers : answersList) {
            PageInfo<Usercomments> uclist = userCommentsServices.queryCommentsByFkid(pageNum, answers.getAwid(), "2");
            answers.setUsercommentsPageInfo(uclist);
        }
        questionsServices.updateQuestionClickCount(qid);
        answersPageInfo.setList(answersList);
        Integer result = 0;
        Integer result2 = 0;
        if (users != null) {
            if (careQuestionsServices.detailCarequestions(users.getUserid(), qid) != null) {
                result = 1;
            }
            if (caresServices.queryCountByCares(users.getUserid(), question.getUsers().getUserid()) != 0) {
                result2 = 1;
            }
        }
        model.addAttribute("carequestionuserlist", careQuestionsServices.queryUsersByCares(pageNum, qid));
        model.addAttribute("careuserlist", caresServices.queryAllByBecardid(pageNum, question.getUsers().getUserid()));
        model.addAttribute("result", result);
        model.addAttribute("result2", result2);
        model.addAttribute("questionstypeList", questionstypeList);
        model.addAttribute("question", question);
        model.addAttribute("answersPageInfo", answersPageInfo);
        return "answer";
    }

    /*
     * awtime=2018-11-23 18:45:56.0
     * */
    @RequestMapping("careListControlller")
    public String careList(Model model, @RequestParam(required = false, defaultValue = "1") Integer PageNum, HttpSession session) {
        Users users = (Users) session.getAttribute("user");
        //创建比较器
       if(users!=null){
           ComparatorConfig comparatorConfig = new ComparatorConfig();
           //创建父集合
           List<Object> objectList = new ArrayList<Object>();
           //获取关注者集合
           List<Integer> userids = new ArrayList<Integer>();
           for (Cares care : caresServices.getAllCaresId(users.getUserid())) {
             userids.add(care.getBecardid());
           }
           //获取被关注者发表的话题
           List<Questions> questionsList = questionsServices.queryQuestionsByUsersids(userids);
           for (Questions questions : questionsList) {
               PageInfo<Answers> answersPageInfo = answersServices.queryAnswersByQid(PageNum, questions.getQid());
               questions.setAnswersList(answersPageInfo.getList());
           }
           //获取关注者发表的回答
           List<Answers> answersList = answersServices.queryAnswersByUsersids(userids);
           for (Answers answers : answersList) {
               PageInfo<Usercomments> usercommentsPageInfo = userCommentsServices.queryCommentsByFkid(PageNum, answers.getAwid(), "2");
               answers.setUsercommentsPageInfo(usercommentsPageInfo);
           }
           //获取关注者发表的动态
           List<Userstalks> userstalksList = usersTalksServices.queryUserTalksByuserids(userids);
           for (Userstalks userstalks : userstalksList) {
               PageInfo<Usercomments> usercommentsPageInfo = userCommentsServices.queryCommentsByFkid(PageNum, userstalks.getUtid(), "4");
               userstalks.setUsercommentsPageInfo(usercommentsPageInfo);
           }
           objectList.addAll(questionsList);
           objectList.addAll(answersList);
           objectList.addAll(userstalksList);
           //排序后的集合
           Collections.sort(objectList, comparatorConfig);
       /* for(Object object : objectList){
            System.out.println("before:"+object);
        }*/
           /* Collections.sort(objectList,comparatorConfig);*/
     /* for(Object object : objectList){
           System.out.println("later:"+object);
       }*/
           PageClass pageClass = new PageClass();

           // 1      2       3
           pageClass.setPageNum(PageNum);//0:2    3:5     6:8
           pageClass.setObjectList(objectList.subList(PageNum - 1, (PageNum - 1) * 3));
           model.addAttribute("objectList", objectList);
       }
        return "care";
    }

}
