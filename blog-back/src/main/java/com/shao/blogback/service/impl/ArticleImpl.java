package com.shao.blogback.service.impl;

import com.shao.blogback.dao.ArticleDao;
import com.shao.blogback.model.Article;
import com.shao.blogback.model.ArticleArchives;
import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public boolean saveArticle(Article article) {
        return articleDao.saveArticle(article);
    }

    @Override
    public ResponseBase updateArticle(Article article) {
        articleDao.updateArticle(article);
        return new ResponseBase(ResponseBase.SUCCESS, "更新文章信息成功", null);
    }

    @Override
    public Article getArticleByAId(String article_id) {
        return articleDao.getArticleByAId(article_id);
    }

    @Override
    public List<Article> getArticleByTag(String article_tag) {
        //获取所有文章
        if (article_tag.equals("all")) {
            return articleDao.getAllArticle();
        } else {
            return articleDao.getArticleByTag(article_tag);
        }
    }

    @Override
    public List<ArticleArchives> getArticleYearByTag(String article_tag) {
        //获取所有文章
        if (article_tag.equals("all")) {
            return articleDao.getAllArticleYear();
        } else {
            return articleDao.getArticleYearByTag(article_tag);
        }
    }
}
