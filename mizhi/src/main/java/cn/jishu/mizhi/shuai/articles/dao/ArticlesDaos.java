package cn.jishu.mizhi.shuai.articles.dao;

import cn.jishu.mizhi.entity.Articles;

import java.util.List;

public interface ArticlesDaos {
    List<Articles> queryAll(Integer userid);
}
