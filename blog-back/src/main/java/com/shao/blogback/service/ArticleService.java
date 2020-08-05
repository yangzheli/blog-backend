package com.shao.blogback.service;

import com.shao.blogback.model.Article;
import com.shao.blogback.model.ArticleArchives;
import com.shao.blogback.model.ResponseBase;

import java.util.List;

public interface ArticleService {
    boolean saveArticle(Article article);

    ResponseBase updateArticle(Article article);

    Article getArticleByAId(String article_id);

    List<Article> getArticleByTag(String article_tag);

    List<ArticleArchives> getArticleYearByTag(String article_tag);
}
