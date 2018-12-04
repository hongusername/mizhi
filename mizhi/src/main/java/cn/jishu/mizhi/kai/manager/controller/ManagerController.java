package cn.jishu.mizhi.kai.manager.controller;

import cn.jishu.mizhi.entity.ManagerUser;
import cn.jishu.mizhi.entity.Member;
import cn.jishu.mizhi.entity.Questions;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.kai.manager.server.ManagerService;
import cn.jishu.mizhi.kai.manager.server.ManagerUserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.catalina.Manager;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: mizhi
 * @description: ${description}
 * @author: ShiDunKai
 * @create: 2018-11-24 17:25
 **/
@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @Resource
    private ManagerUserService managerUserService;
    /**
     * @Description: 用户方法
     * @Param: []
     * @return: java.util.List<cn.jishu.mizhi.entity.Users>
     * @Author: ShiDunKai
     * @Date: 2018/11/23
     */
   /* List<Users> queryAllUser();
    Users qeuryUsersById(@Param("userId") Integer userid);
    Integer updateUserStatus(@Param("updateUser") Users users);*/
   @RequestMapping("managerindex")
   public String shouye(){
       return "017/index";
   }
   @RequestMapping("ManagerController")
    public String toDengLu(){
        return "017/login";
    }

  /*  //跳转日志页面
    @RequestMapping("riziHtml")
    public String tiaoRi(){
        return "017/timeline";
    }*/

    @RequestMapping("UserTable")
    public String userTable(Map map){
      /* , @RequestParam(value = "msg",defaultValue = "0")String msg*/
       map.put("userAll",managerService.queryAllUser());
       /*map.put("msg",msg);*/
       return "017/profile";
    }
    @RequestMapping("index")
    public String index(){
       return "017/index";
    }

    @RequestMapping("queryByUserId")
    @ResponseBody
    public List<Object> queryByid(Integer id){
        System.out.println(id);
        Users user=managerService.qeuryUsersById(id);
        System.out.println(user);
        Date date=new Date();
        date=user.getBirthday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date2=format.format(date);
        System.out.println(date2);
        List<Object> list=new ArrayList<>();
        list.add(0,user);
        list.add(1,date2);
       return list;
    }
    @RequestMapping("queryQuestionType")
    @ResponseBody
    public List<Questions> queryById(Integer id, Map map){
        System.out.println(id);
        System.out.println(managerService.queyrTypeById(id));
       return managerService.queyrTypeById(id);
    }

    @RequestMapping("qeuryMemberById")
    @ResponseBody
    public Member queryByMemberId(Integer id){
       Member member=managerService.queryByMemberById(id);
       return member;
    }


    //修改用户状态
    @RequestMapping("updateUserStatus")
    @ResponseBody
    public Users updateUserStatic(Integer id){
       Users users=managerService.qeuryUsersById(id);
      return users;
    }

    @RequestMapping("udpatestatus")
    public String updateStatus(Integer id, String status, RedirectAttributes redirectAttributes,HttpSession session){
        Integer sessionId=((ManagerUser)session.getAttribute("managerUser")).getMUid();

       Users users=new Users();
       users.setUserid(id);
       users.setUstatus(status);
       if(id!=null&&status!=null&&users!=null){
           managerService.updateUserStatus(users);
           redirectAttributes.addFlashAttribute("msg","修改成功!");
/*修改用户状态*/
           cn.jishu.mizhi.entity.ManagerController managerController=new cn.jishu.mizhi.entity.ManagerController();
           managerController.setMCtype(1);
           managerController.setMmid(sessionId);
           managerController.setMCcontext("修改了用户id为"+id+"的信息");
           managerUserService.insertContext(managerController);
           return "redirect:/UserTable";
       }else{
           redirectAttributes.addFlashAttribute("msg","修改失败，请稍后重试！");
           return "redirect:/UserTable";
       }
    }

    @RequestMapping("updateQstatus")
    public String updateQStatus(Integer id,String qstatus,RedirectAttributes redirectAttributes,HttpSession session){
        Integer sessionId=((ManagerUser)session.getAttribute("managerUser")).getMUid();
       Questions questions=new Questions();
       questions.setQid(id);
        String id2="1";
       if(qstatus.equals(id2)){
           questions.setQuestionstatus("0");
           System.out.println(qstatus);
       }else{
           questions.setQuestionstatus("1");
           System.out.println(qstatus);
       }
       managerService.updateStatus(questions);
       if(managerService.updateStatus(questions)>0) {
           redirectAttributes.addFlashAttribute("mqs", "修改话题状态成功！");
/*修改话题状态*/
           cn.jishu.mizhi.entity.ManagerController managerController=new cn.jishu.mizhi.entity.ManagerController();
           managerController.setMCcontext("修改了话题id="+id+"的状态");
           managerController.setMCtype(2);
           managerController.setMmid(sessionId);
           managerUserService.insertContext(managerController);
           return "redirect:/qeuryQuestion";
       }else{
           redirectAttributes.addFlashAttribute("mqs","修改话题状态失败，请稍后重试！");
           return "redirect:/qeuryQuestion";
       }
    }

    @RequestMapping("qeuryQuestion")
    public String queryByAllQuestion(Map map){
       map.put("questionAll",managerService.qeuryAllQuestions());
        System.out.println(managerService.qeuryAllQuestions());
       return "017/pricing";
    }

    @RequestMapping("queryAllMamber")
    public String queryAllMember(Map map){
       map.put("memberAll",managerService.queryAll());
       return "017/invoice";
    }
    @RequestMapping("deleteByMemberById")
    public String deleteByQuestionId(Integer id,HttpSession session){
        System.out.println(id);
       managerService.deleteByQuestionId(id);

/*删除话题*/
        Integer sessionId=((ManagerUser)session.getAttribute("managerUser")).getMUid();
        cn.jishu.mizhi.entity.ManagerController managerController=new cn.jishu.mizhi.entity.ManagerController();
        managerController.setMmid(sessionId);
        managerController.setMCtype(3);
        managerController.setMCcontext("删除会员id="+id+"的信息");
        managerUserService.insertContext(managerController);
        System.out.println(managerService.deleteByQuestionId(id));
       return  "forward:queryAllMamber";
    }

    @RequestMapping("updateMember")
    public String updateMember(Member member,RedirectAttributes redirectAttributes,HttpSession session){
       managerService.updateMember(member);
       if(managerService.updateMember(member)>0){
           redirectAttributes.addFlashAttribute("mms","修改会员信息成功！");
/*修改会员信息*/
           Integer sessionId=((ManagerUser)session.getAttribute("managerUser")).getMUid();
           cn.jishu.mizhi.entity.ManagerController managerController=new cn.jishu.mizhi.entity.ManagerController();
           managerController.setMCcontext("修改了会员id="+member.getMid()+"的信息");
           managerController.setMmid(sessionId);
           managerController.setMCtype(3);
           managerUserService.insertContext(managerController);
       }else{
           redirectAttributes.addFlashAttribute("mms","修改会员信息失败！");
       }
       return "redirect:/queryAllMamber";
    }

    @RequestMapping("ajaxQueryByUsername")
    @ResponseBody
    public Boolean ajaxController(String username){
        ManagerUser managerUser=new ManagerUser();
        if(username.length()!=0){
            managerUser=managerUserService.mQueryByUserName(username);
            if(managerUser!=null && managerUser.getMUserName()!=null){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }

    @RequestMapping("loginManagerUser")
    public String loginManagerController(String username, String password, RedirectAttributes redirectAttributes, HttpSession session){
       ManagerUser managerUser=managerUserService.mLogin(username,password);
       if(managerUserService.mLogin(username,password)!=null){
           session.setAttribute("managerUser",managerUser);
           //redirectAttributes.addFlashAttribute("msg","登录成功！");
           System.out.println("登陆成功");
           return "redirect:/managerindex";
       }else{
           redirectAttributes.addFlashAttribute("msg","登录失败！请重新登录！");
           session.removeAttribute("managerUser");
           System.out.println("登录失败");
           return "redirect:/ManagerController";
       }
    }

    @RequestMapping("queryForContext")
    public String queryQueryForManagerContext(Map map,HttpSession session,RedirectAttributes redirectAttributes){
       Integer id=((ManagerUser)session.getAttribute("managerUser")).getMUid();
       if(id!=null){
           redirectAttributes.addFlashAttribute("rizhimsg","获取后台管理员信息成功！");
           map.put("rizhi",managerUserService.queryAllManagerUser(id));
           return "017/timeline";
       }else{
           redirectAttributes.addFlashAttribute("rizhimsg","获取后台管理员信息失败！请重新登录！");
           return "redirect:/ManagerController";
       }
    }

    //随机数方法
    public Integer random(){
        int num = (int) (Math.random() * 5 + 1);
       return num;
    }

    @RequestMapping("riziHtml")
    public String rZBySession(HttpSession session,Map map){
       Integer sessionId=((ManagerUser)session.getAttribute("managerUser")).getMUid();
       //获取日期list
       List<cn.jishu.mizhi.entity.ManagerController> managerControllerList=managerUserService.mCdate(sessionId);
        System.out.println("检查是否获取到了管理员的id和相应的信息"+managerControllerList);
        map.put("rzTimeList",managerControllerList);
       //声明接收日期的对象，里面有list属性
       //cn.jishu.mizhi.entity.ManagerController managerController=new cn.jishu.mizhi.entity.ManagerController();
        //循环调用一下随机数，然后进入到list中去，页面随机赋予样式
        List<Integer> numList=new ArrayList<>();
        // 循环日期list
       for(int i=0;i<managerControllerList.size();i++){
           numList.add(i,random());
           //获取循环的日期第i个
           Date date=managerControllerList.get(i).getMCtime();
           SimpleDateFormat format=new SimpleDateFormat();
           //转换
           String date1=format.format(date);
           //将转换的日期set进含有list类里面
          // managerController.setManagerControllerList(managerUserService.mContext(date1));
           managerControllerList.get(i).setManagerControllerList(managerUserService.mContext(date1));
       }
       map.put("rzContextList",managerControllerList);
        System.out.println("检查随机数"+numList+"检查是否已经成功获取到了用户相应的信息条件然后进行输出集合"+managerControllerList.get(0).getManagerControllerList());
        return "017/timeline";
    }

}
