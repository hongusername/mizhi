package cn.jishu.mizhi.shuo.articles.service.impl;

import cn.jishu.mizhi.entity.Articles;
import cn.jishu.mizhi.entity.Articletype;
import cn.jishu.mizhi.shuo.articles.dao.ArticlesDao;
import cn.jishu.mizhi.shuo.articles.service.ArticlesService;
import cn.jishu.mizhi.shuo.articletype.dao.ArticletypeDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public Integer delarticle(Integer artid) {
        return ad.delarticle(artid);
    }

    @Override
    public PageInfo<Articles> queryAll(Integer pageNum, Integer pageSize, Integer userid) {
        PageHelper.startPage(pageNum,pageSize);

        List<Articles> list=new ArrayList<Articles>();
        for (Articles art:ad.queryAll(userid)) {
            if(art.getArticlestatus().equals("1")){
                list.add(art);
            }
        }
        for (Articles art:list) {
            System.out.println(art);
        }
        PageInfo<Articles> pi=new PageInfo<Articles>(list);
        return pi;
    }

    @Override
    public Integer querymaxid() {
        return ad.querymaxid();
    }

    @Override
    public Integer addarticle(Articles articles) {
        return ad.addarticle(articles);
    }

    @Override
    public Integer updatearticle(Articles articles) {
        return ad.updatearticle(articles);
    }

    @Override
    public Articles queryByarticlesid(Integer arid) {
        return ad.queryByarticlesid(arid);
    }

    @Override
    public Integer updatestatus(Articles articles) {
        return ad.updatearticle(articles);
    }

    @Override
    public PageInfo<Articles> queryAllbyuserid(Integer pageNum, Integer pageSize, Articles articles) {
        PageHelper.startPage(pageNum,pageSize);
        List<Articles> list=ad.queryAllbyuserid(articles);
        PageInfo<Articles> pi=new PageInfo<Articles>(list);
        return pi;
    }
    @Override
    public Integer addfileinfo() {
        return ad.addfileinfo();
    }

    /*查询所有文章类型*/
    @Resource
    private ArticletypeDao atd;
    @Override
    public List<Articletype> queryAllArtitcleType() {
        return atd.queryAllArtitcleType();
    }
}
