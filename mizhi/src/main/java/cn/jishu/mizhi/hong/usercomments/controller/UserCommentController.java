package cn.jishu.mizhi.hong.usercomments.controller;

import cn.jishu.mizhi.entity.Usercomments;
import cn.jishu.mizhi.hong.usercomments.services.UserCommentsServices;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserCommentController {
    @Resource
    private UserCommentsServices userCommentsServices;

    @RequestMapping("toCommentController")
    public String toCommentPage(@RequestParam(defaultValue = "3", required = false) Integer pageSize, @RequestParam(required = false, defaultValue = "1") Integer pageNum, Model model, int fkid, @RequestParam(required = false, defaultValue = "0") Integer parentid) {
        //查询某条具体被回复的评论
        Usercomments usercomments = userCommentsServices.detailUserCommentByTcid(parentid);
        model.addAttribute("usercomments", usercomments);
        //查询某条评论下的所有回复
        PageInfo<Usercomments> usercommentsPageInfo = userCommentsServices.queryCommentsByFkid(pageNum, pageSize, fkid, "2", parentid);
        model.addAttribute("usercommentsPageInfo", usercommentsPageInfo);
        model.addAttribute("fkid",fkid);
        model.addAttribute("parentid",parentid);
        return "usercomment";
    }

    //ajax切换回复页面分页
    @RequestMapping("ajaxPageCommentsController")
    @ResponseBody
    public PageInfo<Usercomments> ajaxPageComments(@RequestParam(required = false,defaultValue = "1")Integer pageNum,@RequestParam(required = false,defaultValue = "3")Integer pageSize,int fkid, @RequestParam(required = false, defaultValue = "0") Integer parentid){
        PageInfo<Usercomments> page = userCommentsServices.queryCommentsByFkid(pageNum,pageSize,fkid,"2",parentid);
        System.out.println(page.getList().size());
        return page;
    }
}
