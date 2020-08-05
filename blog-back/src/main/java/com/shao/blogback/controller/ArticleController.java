package com.shao.blogback.controller;

import com.shao.blogback.model.Article;
import com.shao.blogback.model.ArticleArchives;
import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "文章管理相关接口")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation("保存文章接口")
    @PostMapping("article/saveArticle")
    public boolean saveArticle(Article article) {
        return articleService.saveArticle(article);
    }

    @ApiOperation("保存文章接口")
    @PostMapping("article/updateArticle")
    public ResponseBase updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @ApiOperation("根据文章ID获取文章接口")
    @GetMapping("article/getArticleByAId")
    public Article getArticleByAId(String article_id) {
        return articleService.getArticleByAId(article_id);
    }

    @ApiOperation("根据标签取文章列表接口")
    @GetMapping("article/getArticleByTag")
    public List<Article> getArticleByTag(String article_tag) {
        return articleService.getArticleByTag(article_tag);
    }

    @ApiOperation("获取归档后文章年份接口")
    @GetMapping("article/getArticleYearByTag")
    public List<ArticleArchives> getArticleYearByTag(String article_tag) {
        return articleService.getArticleYearByTag(article_tag);
    }
}
