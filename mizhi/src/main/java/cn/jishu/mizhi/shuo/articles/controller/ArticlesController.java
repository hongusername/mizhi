package cn.jishu.mizhi.shuo.articles.controller;

import cn.jishu.mizhi.entity.Articles;
import cn.jishu.mizhi.shuo.articles.service.ArticlesService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Program：mizhi
 * @Description：coreController
 * @Author：LearnLi
 * @Create:2018-11-26 18:17
 */

@Controller
public class ArticlesController {

/*
    @Resource
    private ArticlesService as;

    */
/*新增草稿*//*

    @RequestMapping("/addArticle")
    @ResponseBody
    public Integer ajaxdoAdd(String param) {
        Articles a=null;
        ObjectMapper om=new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            a=om.readValue(param,Articles.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer row=as.addarticle(a);
        return row;
    }



    @RequestMapping("/updateArticle")
    @ResponseBody
    public Integer ajaxdoUpdate(String param) {
        Articles a=null;
        ObjectMapper om=new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            a=om.readValue(param,Articles.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer row=as.updatearticle(a);
        return row;
    }

    @RequestMapping("/updateArticle")
    public Integer updateStatus(String param) {
        Articles a=null;
        ObjectMapper om=new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            a=om.readValue(param,Articles.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer row=as.updatearticle(a);
        return row;
    }
*/

}
