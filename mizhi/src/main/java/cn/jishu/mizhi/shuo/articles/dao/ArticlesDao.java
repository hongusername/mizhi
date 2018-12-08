package cn.jishu.mizhi.shuo.articles.dao;

import cn.jishu.mizhi.entity.Articles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Program：mizhi
 * @Description：dao
 * @Author：LearnLi
 * @Create:2018-11-23 16:26
 */

public interface ArticlesDao {

    List<Articles> queryAll(Integer userid);//查询所有文章
    Integer querymaxid();//查询最大Sid
    Integer addarticle(@Param("articles") Articles articles);//增加草稿
    Integer updatearticle(@Param("articles") Articles articles);//ajax修改
    Integer updatestatus(@Param("articles") Articles articles);//发布
    Integer delarticle(Integer artid);//修改状态（删除）
    Articles queryByarticlesid(Integer arid);//通过id查看
    List<Articles> queryAllbyuserid(@Param("articles") Articles articles);//通过用户，状态查询文章
    Integer addfileinfo();//储存用户发布的文件信息
}
