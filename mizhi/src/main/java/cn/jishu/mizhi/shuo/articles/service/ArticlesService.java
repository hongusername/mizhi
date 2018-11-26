package cn.jishu.mizhi.shuo.articles.service;

import cn.jishu.mizhi.entity.Articles;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Program：mizhi
 * @Description：dao
 * @Author：LearnLi
 * @Create:2018-11-23 16:26
 */

public interface ArticlesService {

    Integer addarticle(Articles articles);//增加草稿
    Integer updatearticle(Articles articles);//ajax修改
    Integer updatestatus(Articles articles);//发布，删除
    PageInfo<Articles> queryALlbyuserid(Integer pageNum, Integer pageSize,Articles articles);//查询用户的所有草稿
    Integer addfileinfo();//储存用户发布的文件信息
    



}
