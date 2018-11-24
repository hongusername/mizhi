package cn.jishu.mizhi;

import cn.jishu.mizhi.entity.Member;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import cn.jishu.mizhi.hong.userstalks.services.UsersTalksServices;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
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

    @Resource
    private ManagerService managerService;
    @Test
    public void contextLoads() {
        System.out.println(1234);
    }
/*

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
*/
//查询所有用户
@Test
public void testQueryALl(){
    System.out.println(managerService.queryAllUser());
}
    //根据id查询问题类型
    @Test
    public void testQueryById(){
        System.out.println(managerService.queyrTypeById(1).get(0).getQuestionstypes());
    }
    //根据id查询用户
    @Test
    public void testQueryAllUserByid(){
        System.out.println(managerService.qeuryUsersById(1));
    }
    //根据用户id修改用户状态
    @Test
    public void testDeleteUserById(){
        System.out.println(managerService.updateUserStatus(new Users(1,"sd","sd","sd","sd","sd",null,null,"sd",1,1,1,"sd","sd","3",null,null,null,null,null,null,null,null,null,null,null,null,null,null)));
    }
    //查询所有话题
    @Test
    public void testQueryByQuestionById(){
        System.out.println(managerService.qeuryAllQuestions());
    }
    //修改话题状态
    @Test
    public void testUpdateQuestion(){
        System.out.println(managerService.updateStatus(new Questions(1,null,null,null,"0",null,null,null,null,null)));
    }
    //查询所有话题
    @Test
    public void testQueryAllMember(){
        System.out.println(managerService.queryAll());
    }
    //根据id进行删除话题
    @Test
    public void testDeleteMemberById(){
        System.out.println(managerService.deleteByQuestionId(5));
    }
    //插入话题
    @Test
    public void testInsertForMember(){
        System.out.println(managerService.insertMember(new Member(null,"sanji",1,1,12,12)));
    }
    //更新话题
    @Test
    public void testUpdateMember(){
        System.out.println(managerService.updateMember(new Member(6,"sanji",11,12,14,4)));
    }



}
