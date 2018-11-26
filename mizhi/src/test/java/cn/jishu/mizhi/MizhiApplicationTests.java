package cn.jishu.mizhi;

import cn.jishu.mizhi.entity.*;
import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import cn.jishu.mizhi.hong.userstalks.services.UsersTalksServices;
import cn.jishu.mizhi.hui.books.service.BooksService;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import cn.jishu.mizhi.shuo.articles.service.ArticlesService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    public void testQueryALl() {
        System.out.println(managerService.queryAllUser());
    }

    //根据id查询问题类型
    @Test
    public void testQueryById() {
        System.out.println(managerService.queyrTypeById(1).get(0).getQuestionstypes());
    }

    //根据id查询用户
    @Test
    public void testQueryAllUserByid() {
        System.out.println(managerService.qeuryUsersById(1));
    }

    //根据用户id修改用户状态
    @Test
    public void testDeleteUserById() {
        System.out.println(managerService.updateUserStatus(new Users(1, "sd", "sd", "sd", "sd", "sd", null, null, "sd", 1, 1, 1, "sd", "sd", "3", null, null, null, null, null, null, null, null, null, null, null, null, null, null)));
    }

    //查询所有话题
    @Test
    public void testQueryByQuestionById() {
        System.out.println(managerService.qeuryAllQuestions());
    }

    //修改话题状态
    @Test
    public void testUpdateQuestion() {
        System.out.println(managerService.updateStatus(new Questions(1, null, null, null, "0", null, null, null, null, null)));
    }

    //查询所有话题
    @Test
    public void testQueryAllMember() {
        System.out.println(managerService.queryAll());
    }

    //根据id进行删除话题
    @Test
    public void testDeleteMemberById() {
        System.out.println(managerService.deleteByQuestionId(5));
    }

    //插入话题
    @Test
    public void testInsertForMember() {
        System.out.println(managerService.insertMember(new Member(null, "sanji", 1, 1, 12, 12)));
    }

    //更新话题
    @Test
    public void testUpdateMember() {
        System.out.println(managerService.updateMember(new Member(6, "sanji", 11, 12, 14, 4)));
    }

    /*以下是books的测试类*/
    @Resource
    private BooksService booksService;

    /**
     * 查询书
     */
    @Test
    public void queryBook() {
        PageInfo<Books> booksPageInfo = this.booksService.queryBooksAll(new Books(), 2);
        for (Books b : booksPageInfo.getList()) {
            System.out.println(b);
        }
    }

    /**
     * 增加书
     */
    @Test
    public void addBooks() {
        for (int i = 1; i < 1000; i++) {
            Booktype b = new Booktype();
            b.setBtid(1);
            Books books = new Books(null, b, "三国演义《" + i + "》", "党二帅", "东汉末年，天下三分", "魏蜀吴三国开启了撕逼模式", null, "1", 22, 88.2, 44.2, "三英战吕布，吕布死，欲知后事如何，请见下回分解，", "///", 22, null, null);
            int a = this.booksService.addBooks(books);
        }
    }


    /**
     * LearnLi
     *    private Integer articleid;//主键
     *     private Users users;//外键 用户编号
     *     private Articletype articletype;//外键 文章类型编号,
     *     private String atitle;//文章标题
     *     private String aimg;//文章图片
     *     private String acontent;//文章内容
     *     private Integer clickcount,agreecount,disagreecount;//浏览量,赞同量,反对量
     *     private String articlestatus;//文章状态 1.草稿 2.撤销3.发布
     *     private Timestamp articletime;//文章发表时间
     *     private Integer rewardscore,rewardcount;//打赏总积分,打赏总次数
     *     private List<Userstalks> userstalksList;
     */

    @Resource
    private ArticlesService as;
    //增加文章
    @Test
    public void testaddA(){
        Users users=new Users();
        Articletype articletype=new Articletype();
        users.setUserid(1);
        articletype.setArticletypeid(1);
        Articles a=new Articles(null,users,articletype,"我是标题","","我是内容",4,0,0,0,"1",new Timestamp(new Date().getTime()),0,0,null);
        Integer res=as.addarticle(a);
        System.out.println(res);
    }

}
