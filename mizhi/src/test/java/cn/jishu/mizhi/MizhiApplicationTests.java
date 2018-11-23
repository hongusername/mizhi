package cn.jishu.mizhi;

import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import cn.jishu.mizhi.hong.userstalks.services.UsersTalksServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MizhiApplicationTests {
   @Resource
    private QuestionsServices questionsServices;
   @Resource
   private AnswersServices answersServices;
   @Resource
   private UserCommentsServices userCommentsServices;
   @Resource
   private UsersTalksServices usersTalksServices;
    @Test
    public void contextLoads() {
        System.out.println(1234);
    }

    @Test
    public void testHongQuestionList(){
       // System.out.println(questionsServices.getQuestionsByQuestionType(1,1));
        List<Integer> list=  new ArrayList<>();
        list.add(1);
        System.out.println(questionsServices.queryQuestionsByUsersids(list,-1));
    }
    @Test
    public void testHongAnswersList(){
     //System.out.println(answersServices.queryAnswersByQid(1,1).getList().size());
        List<Integer> list=  new ArrayList<>();
        list.add(1);
        System.out.println(answersServices.queryAnswersByUsersids(list,-1));
    }
    @Test
    public void testHongUserComments(){
        System.out.println(userCommentsServices.queryCommentsByFkid(1,1,"2").getList().size());
    }
    @Test
    public void testHongUsersTalksList(){
        List<Integer> list=  new ArrayList<>();
            list.add(1);
        System.out.println(usersTalksServices.queryUserTalksByuserids(list,-1));
    }



}
