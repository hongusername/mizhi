package cn.jishu.mizhi.hong.like.controller;

import cn.jishu.mizhi.entity.Likecontexts;
import cn.jishu.mizhi.entity.Likes;
import cn.jishu.mizhi.entity.Users;
import cn.jishu.mizhi.hong.like.services.LikesServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LikeController {


    @Resource
    private LikesServices likesServices;

    //添加内容至收藏夹的页面
    @RequestMapping("/toLikeIframeController")                 //要被收藏的文章/回答id
    public String toLikeIframe(HttpSession session, Model model, Integer lcfcid, String lctype) {
        Users users = (Users) session.getAttribute("user");
      /*  Users users = new Users();
        users.setUserid(1);*/
        List<Likes> likesList = likesServices.queryLikesByUserid(users.getUserid());
        for(Likes likes : likesList){
            List<Likecontexts> likecontextsList = likesServices.queryLikecontextsByLid(likes.getLid());
           // System.out.println("size:"+likecontextsList.size());
            likes.setLikecontextsList(likecontextsList);
        }
        Likecontexts likecontexts = new Likecontexts();
        likecontexts.setLcfcid(lcfcid);
        likecontexts.setLctype(lctype);
        List<Likes> queryLikesList = likesServices.quertLikesByLikecontexts(likecontexts);
        model.addAttribute("queryLikesList",queryLikesList);
        model.addAttribute("likesList", likesList);
        model.addAttribute("lcfcid", lcfcid);
        model.addAttribute("lctype", lctype);
        return "likeiframe";
    }

    //新增收藏夹的页面
    @RequestMapping("/toCreateIframeController")
    public String toCreateIframe() {
        return "createlikeiframe";
    }

    //验证收藏夹是否超出两个
    @RequestMapping("ajaxQueryCountController")
    @ResponseBody
    public boolean ajaxQueryCount(HttpSession session) {
        boolean isflag = true;
        //Users users = (Users) session.getAttribute("user");
        Users users = new Users();
        users.setUserid(1);
        Integer result = likesServices.likesCount(users.getUserid());
        if (result >= 2) {
            isflag = false;
        }
        return isflag;
    }

    //创建收藏夹
    @RequestMapping("ajaxCreateLikes")
    @ResponseBody
    public String ajaxCreateLikes(Likes likes, HttpSession session) {
        Users users = (Users) session.getAttribute("user");
        String result = "";
     /*   Users users = new Users();
        users.setUserid(1);*/
        likes.setUsers(users);
        Integer queryLnameResult = likesServices.queryCountByUseridAndLname(users.getUserid(), likes.getLname());
        if (queryLnameResult != 0) {
            result = "1";
        } else {
            Integer res = likesServices.createLikes(likes);
            if (res != 0) {
                result = "2";
            } else {
                result = "3";
            }
        }
        return result;
    }

    @RequestMapping("/ajaxAddLikeContextsController")
    @ResponseBody
    public Integer  ajaxAddLikeContexts(Likecontexts likecontexts, Integer biaoshi) {

        if(biaoshi==1){ //执行添加操作
            likesServices.addLikesContexts(likecontexts);
            return 1;
        }
        else if(biaoshi==2){ //执行删除操作
        likesServices.deleteLikesContextByLidAndLcfcidAndLctype(likecontexts);
            return 2;
        }
        else{
            return 3;
        }

    }

}
