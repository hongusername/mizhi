package cn.jishu.mizhi.shuo.articles.controller;

import cn.jishu.mizhi.entity.Articles;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.shuo.articles.service.ArticlesService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Program：mizhi
 * @Description：coreController
 * @Author：LearnLi
 * @Create:2018-11-26 18:17
 */

@Controller
public class ArticlesController {


    @Resource
    private ArticlesService as;


    @RequestMapping("/aqueryall")
    public String queryAll(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "999") Integer pageSize,Model model,HttpSession session){
        Users u=new Users();
        u.setUserid(1);
        session.setAttribute("user",u);
        Users user=(Users) session.getAttribute("user");
        PageInfo<Articles> pi=as.queryAll(pageNum,pageSize,user.getUserid());
        model.addAttribute("plist",pi);
        return "alledit";
    }

    @RequestMapping("/adetail")
    public String queryArt(@RequestParam(defaultValue = "2") Integer id, Model model, HttpSession session){
        Articles a=as.queryByarticlesid(id);
        model.addAttribute("leibie",as.queryAllArtitcleType());
        model.addAttribute("art",a);
        Users user=new Users();
        user.setUserid(1);
        session.setAttribute("user",user);
        return  "write";
    }


/*新增草稿*/
    @RequestMapping("/aaddArticle")
    @ResponseBody
    public String [] ajaxdoAdd(String param,Model model) throws IOException {
        Integer row=as.addarticle(returnparam(param));
        String [] res={row.toString(),as.querymaxid().toString()};
        return res;
    }


    /*@RequestMapping()
    @ResponseBody
    public del(){

    }*/

    @RequestMapping("/aupdateArticle")
    @ResponseBody
    public Integer ajaxdoUpdate(String param)  throws IOException {
        Integer row=as.updatearticle(returnparam(param));
        return row;
    }

    @RequestMapping("/aupdateStatus")
    public String updateStatus(Articles art) throws IOException{
        if(art.getArticlestatus().equals("")||art.getArticlestatus()==null){
            art.setArticlestatus("2");
        }
        Integer row=as.updatestatus(art);
        if(row==1){
        return "";
        }
        return "error";
    }

    public Articles returnparam(String param) throws IOException {
        System.out.println("参数："+param);
        Articles a=null;
        ObjectMapper om=new ObjectMapper();//创建
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);//声明不寻找全部字段（加不加效果相同）
        a=om.readValue(param, Articles.class);
        System.out.println("反序列化之后的值是："+a);
        return a;
    }

    /*public static Object getobjfromjsonarrstr(String json,Class beanclass){

        JSONObject jsonobject=(JSONObject)JSONSerializer.toJSON(json);
        return JSONObject.toBean(jsonobject, beanclass);
    }*/

}
