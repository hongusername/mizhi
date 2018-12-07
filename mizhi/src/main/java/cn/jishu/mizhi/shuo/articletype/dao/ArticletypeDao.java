package cn.jishu.mizhi.shuo.articletype.dao;

import cn.jishu.mizhi.entity.Articletype;

import java.util.List;

/**
 * @Program：mizhi
 * @Description：文章类别
 * @Author：LearnLi
 * @Create:2018-11-27 15:22
 */


public interface ArticletypeDao  {
    //查询所有
    List<Articletype> queryAllArtitcleType();
}
