package cn.jishu.mizhi.hong.answers.controller;

import cn.jishu.mizhi.entity.Carequestions;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.carequestions.services.CareQuestionsServices;
import cn.jishu.mizhi.hong.cares.services.CaresServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class answerController {

    @Resource
    private CareQuestionsServices careQuestionsServices;
    @Resource
    private CaresServices caresServices;


    @RequestMapping("careQestionContorller")
    @ResponseBody
    public List<Object> careQestion(HttpSession session, Integer qid, Integer biaoshi) {
        List<Object> objectList = new ArrayList<Object>();
        Users users = (Users) session.getAttribute("user");
      /*  Users users = new Users();
        users.setUserid(1);*/
        System.out.println("biaoshi2:"+biaoshi);
        if (biaoshi == 1) {
            careQuestionsServices.addQuestion(users.getUserid(), qid);
            objectList.add(1);
        } else {
            careQuestionsServices.deleteQuestion(users.getUserid(), qid);
            objectList.add(2);
        }
        objectList.add(careQuestionsServices.queryUsersByCares(1, qid));
        return objectList;
    }


    @RequestMapping("/careUsersContorller")
    @ResponseBody
    public List<Object> careUser(HttpSession session, Integer becardid, Integer biaoshi) {
        List<Object> objectList = new ArrayList<Object>();
        System.out.println(biaoshi);
        // Users users = (Users) session.getAttribute("user");
        Users users = new Users();
        users.setUserid(1);
        if (biaoshi == 1) {
            caresServices.addCaresByUsers(users.getUserid(), becardid);
            objectList.add(1);
        } else {
            caresServices.deleteCaresByUsers(users.getUserid(), becardid);
            objectList.add(2);
        }
        objectList.add(caresServices.queryAllByBecardid(1, becardid));
        return objectList;
    }


}
