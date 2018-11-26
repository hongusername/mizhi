package cn.jishu.mizhi.shuo.articles.service.impl;

import cn.jishu.mizhi.entity.Articles;
import cn.jishu.mizhi.shuo.articles.dao.ArticlesDao;
import cn.jishu.mizhi.shuo.articles.service.ArticlesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Program：mizhi
 * @Description：文章实现类
 * @Author：LearnLi
 * @Create:2018-11-24 10:15
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {


    @Resource
    private ArticlesDao ad;

    @Override
    public Integer addarticle(Articles articles) {
        return ad.addarticle(articles);
    }

    @Override
    public Integer updatearticle(Articles articles) {
        return ad.updatearticle(articles);
    }

    @Override
    public Integer updatestatus(Articles articles) {
        return ad.updatearticle(articles);
    }

    @Override
    public PageInfo<Articles> queryALlbyuserid(Integer pageNum, Integer pageSize, Articles articles) {
        PageHelper.startPage(pageNum,pageSize);
        List<Articles> list=ad.queryALlbyuserid(articles);
        PageInfo<Articles> pi=new PageInfo<Articles>(list);
        return pi;
    }


    @Override
    public Integer addfileinfo() {
        return ad.addfileinfo();
    }
}
