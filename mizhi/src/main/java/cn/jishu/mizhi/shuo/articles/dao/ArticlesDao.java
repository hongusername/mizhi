package cn.jishu.mizhi.shuo.articles.dao;

import cn.jishu.mizhi.entity.Articles;

import java.util.List;

/**
 * @Program：mizhi
 * @Description：dao
 * @Author：LearnLi
 * @Create:2018-11-23 16:26
 */

public interface ArticlesDao {

    Integer addarticle(Articles articles);//增加草稿
    Integer updatearticle(Articles articles);//ajax修改
    List<Articles> queryALlbyuserid(Integer userid);//查询用户的所有草稿
    Integer addfileinfo();//储存用户发布的文件信息




}
