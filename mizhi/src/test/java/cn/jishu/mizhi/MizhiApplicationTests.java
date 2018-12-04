package cn.jishu.mizhi;

import cn.jishu.mizhi.entity.*;
import cn.jishu.mizhi.hong.answers.services.AnswersServices;
import cn.jishu.mizhi.hong.cares.services.CaresServices;
import cn.jishu.mizhi.hong.questions.services.QuestionsServices;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import cn.jishu.mizhi.hong.userstalks.services.UsersTalksServices;
import cn.jishu.mizhi.hui.books.service.BooksService;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import cn.jishu.mizhi.kai.manager.server.ManagerUserService;
import cn.jishu.mizhi.shuo.articles.service.ArticlesService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private BooksService booksService;
    @Resource
    private ManagerService managerService;
    @Resource
    private ManagerUserService managerUserService;

    /**
     *
     */
    @Test
    public void queryBook() {
        Books bb = new Books();
        // bb.setAuthor("马旭辉");
        Booktype b2 = new Booktype();
        b2.setBtid(2);
        bb.setBooktype(b2);
        PageInfo<Books> booksPageInfo = this.booksService.queryBooksAll(bb, 1);
        for (Books b : booksPageInfo.getList()) {
            System.out.println(b);
        }
    }


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

    @Test
    public void testQueryByUserId() {
        System.out.println(managerService.queyrTypeById(1));

        //根据id查询问题类型
   /* @Test
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
    @Test
    public void queryByid(){
        Integer id=1;
        Users user=managerService.qeuryUsersById(id);
       *//* String date=user.getBirthday().toString()+"00";
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
        Date d = null;
        try {
            d=(Date) format.parse(date);
            System.out.println("++++++++++"+d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
       *//*
       Date date=new Date();
       date=user.getBirthday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date2=format.format(date);
        System.out.println(date2);
        List<Object> list=new ArrayList<>();
        list.add(0,user);
        list.add(1,date2);
        System.out.println(list);
    }

    //查询话题根据id
    @Test
     public void testQueryByQmid(){
        System.out.println(managerService.queryByMemberById(4));
    }

    //更新话题
    @Test
    public void testUpdateMember() {
        System.out.println(managerService.updateMember(new Member(6, "sanji", 11, 12, 14, 4)));
    }

    */


        /**
         * 增加书
         *//*
    @Test
    public void addBooks() {
        for (int i = 1; i < 1000; i++) {
            Booktype b = new Booktype();
            b.setBtid(1);
            Books books = new Books(null, b, "三国演义《" + i + "》", "党二帅", "东汉末年，天下三分", "魏蜀吴三国开启了撕逼模式", null, "1", 22, 88.2, 44.2, "三英战吕布，吕布死，欲知后事如何，请见下回分解，", "///", 22, null, null);
            int a = this.booksService.addBooks(books);
        }
    }

    *//**
         * 根据id查询书
         *//*
    @Test
    public void testQueryBooksById() {
        System.out.println(this.booksService.queryBooksById(1001));
    }

    *//**
         * 根据name查询书
         *//*
    @Test
    public void testQueryBooksByName() {
        System.out.println(this.booksService.queryBooksByName("西游记"));
    }

    *//**
         * 查询当前用户书架的书
         *//*
    @Test
    public void testQueryJiaAll() {
        List<Books> list = this.booksService.queryJiaAll(1);
        for (Books b : list) {
            System.out.println(b);
        }
    }

    *//**
         * 给当前用户书架增加一本书
         *//*
    @Test
    public void testAddJia() {
        Bookrack b = new Bookrack();
        Books b1 = new Books();
        b1.setBid(2004);
        Users u = new Users();
        u.setUserid(1);
        b.setBooks(b1);
        b.setUsers(u);
        System.out.println(this.booksService.addJia(b));
    }

    *//**
         * 删除当前用户书架的一本书
         *//*
    @Test
    public void testDeleteJia() {
        System.out.println(this.booksService.deleteJia(1, 2003));
    }

    *//**
         * 购买书，增加订单信息
         *//*
    @Test
    public void testAddOrders() {
        Books b = new Books();
        b.setBid(2004);
        Users u = new Users();
        u.setUserid(1);
        Orderform o = new Orderform(null, u, b, null, null, "1", this.booksService.queryBooksById(2002).getNewprice());
        System.out.println(this.booksService.addOrders(o));
    }

    *//**
         * 判断当前用户是否购买了本书
         *//*
    @Test
    public void testQueryOrderByBooks() {
        if (this.booksService.queryOrderByBooks(1, 20044) != null) {
            System.out.println("已购买本书");
        } else {
            System.out.println("未购买本书");
        }
    }

    *//**
         * 查询所有订单信息，组合查询当前用户订单
         *//*
    @Test
    public void testQueryOrderAllByUserId() {
        List<Orderform> list = this.booksService.queryOrderAllByUserId(1);
        for (Orderform o : list) {
            System.out.println(o.getBooks());
        }
    }

    *//**
         * LearnLi
         * private Integer articleid;//主键
         * private Users users;//外键 用户编号
         * private Articletype articletype;//外键 文章类型编号,
         * private String atitle;//文章标题
         * private String aimg;//文章图片
         * private String acontent;//文章内容
         * private Integer clickcount,agreecount,disagreecount;//浏览量,赞同量,反对量
         * private String articlestatus;//文章状态 1.草稿 2.撤销3.发布
         * private Timestamp articletime;//文章发表时间
         * private Integer rewardscore,rewardcount;//打赏总积分,打赏总次数
         * private List<Userstalks> userstalksList;
         *//*

    @Resource
    private ArticlesService as;

    //增加文章
    @Test
    public void testaddA() {
        Users users = new Users();
        Articletype articletype = new Articletype();
        users.setUserid(1);
        articletype.setArticletypeid(1);
        Articles a = new Articles(null, users, articletype, "我是标题", "", "我是内容", 4, 0, 0, 0, "1", new Timestamp(new Date().getTime()), 0, 0, null);
        Integer res = as.addarticle(a);
        System.out.println(res);
    }

    @Test
    public void testB() {
        Articles a = new Articles();
        a.setArticleid(1);
        a.setArticlestatus("2");
        a.setArticletime(new Timestamp(new Date().getTime()));
        Integer ss = as.updatestatus(a);
        System.out.println(ss);
    }

    @Test
    public void testC() {
        Articles a = new Articles();
        Articletype articletype = new Articletype();
        articletype.setArticletypeid(1);
        a.setArticleid(1);
        a.setAtitle("特朗普");
        a.setAcontent("内容那日饿哦那个");
        a.setAimg("http//:localhost:8080");
        a.setAnumber(11);
        a.setArticletype(articletype);

        Integer ss = as.updatearticle(a);
        System.out.println(ss);
    }

    @Test
    public void testD() {

        Articles a = new Articles();
        Users u = new Users();
        u.setUserid(1);
        a.setArticlestatus("1");
        a.setUsers(u);
        PageInfo<Articles> ss = as.queryALlbyuserid(1, 4, a);

        for (Articles ar : ss.getList()) {
            System.out.println(ar);
        }
    }

    */
    }
    @Test
    public void testQueryAllManagerContext(){

        System.out.println(managerUserService.queryAllManagerUser(1));
    }
    @Test
    public void testQueryByUserName(){
        System.out.println(managerUserService.mQueryByUserName("管理员"));
    }

    @Test
    public void testLoginManagerUser(){
        System.out.println(managerUserService.mLogin("管理员","123123"));
    }


    @Test
    public void testQueryBySession(){
        System.out.println(managerUserService.mCdate(1));
    }
    @Test
    public void testQueryByTime() throws ParseException {
        String date="2018-11-13";
        System.out.println(managerUserService.mContext(date));
    }
    public Integer random(){
        int num = (int) (Math.random() * 5 + 1);
        return num;
    }
    @Test
    public void testBySessionId(){
        List<Integer> numList=new ArrayList<>();
        /*List<cn.jishu.mizhi.entity.ManagerController> managerControllerList=managerUserService.mCdate(1);
        //System.out.println("五个日期出来了"+managerControllerList);
        //System.out.println(managerUserService.mContext("2018-11-13"));

        for(int i=0;i<managerControllerList.size();i++){

            Date date=managerControllerList.get(i).getMCtime();
            SimpleDateFormat format=new SimpleDateFormat();
            String date1=format.format(date);
            //System.out.println(""五个日期+date1);
            managerControllerList.get(i).setManagerControllerList(managerUserService.mContext(date1));
            //System.out.println(managerControllerList.size());
           // System.out.println("一个时间"+managerControllerList.get(i).getManagerControllerList());

        }
        System.out.println(numList);
        System.out.println(managerControllerList.get(0).getManagerControllerList());*/
        for(int g=0;g<5;g++){

            numList.add(g,random());
        }
        System.out.println(numList);
    }
    @Test
    public void testInsertContext(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date="2018-11-22";
        try {
            System.out.println( managerUserService.insertContext(new ManagerController(null,1,1,format.parse(date),"没有操作",null)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
