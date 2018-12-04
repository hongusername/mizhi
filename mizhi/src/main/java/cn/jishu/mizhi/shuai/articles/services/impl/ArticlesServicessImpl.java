package cn.jishu.mizhi.shuai.articles.services.impl;

import cn.jishu.mizhi.entity.Articles;
import cn.jishu.mizhi.shuai.articles.dao.ArticlesDaos;
import cn.jishu.mizhi.shuai.articles.services.ArticlesServicess;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ArticlesServicessImpl  implements ArticlesServicess {
    @Resource
    private ArticlesDaos dao;
    @Override
    public List<Articles> queryAll(Integer userid) {
        return dao.queryAll(userid);
    }
}
