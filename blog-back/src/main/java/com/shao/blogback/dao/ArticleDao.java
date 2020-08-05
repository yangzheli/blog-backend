package com.shao.blogback.dao;

import com.shao.blogback.model.Article;
import com.shao.blogback.model.ArticleArchives;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleDao {
    @Insert("INSERT INTO article (user_id,article_title,article_content,article_tags) VALUES (#{user_id},#{article_title},#{article_content},#{article_tags})")
    boolean saveArticle(Article article);

    @Select("UPDATE article SET article_title = #{article_title}, article_content = #{article_content}, article_tags = #{article_tags} where article_id = #{article_id}")
    void updateArticle(Article article);

    @Select("SELECT * FROM article ORDER BY create_time DESC")
    List<Article> getAllArticle();

    @Select("SELECT * FROM article WHERE article_id = #{article_id}")
    Article getArticleByAId(String article_id);

    @Select("SELECT * FROM article WHERE article_tags like CONCAT('%[',#{article_tag},'%]') ORDER BY create_time DESC")
    List<Article> getArticleByTag(String article_tag);

    @Select("SELECT create_year,count(create_year) AS count FROM article GROUP BY create_year ORDER BY create_year DESC")
    List<ArticleArchives> getAllArticleYear();

    @Select("SELECT create_year,count(create_year) AS count FROM article WHERE article_tags like CONCAT('%[',#{article_tag},'%]') " +
            "GROUP BY create_year ORDER BY create_year DESC")
    List<ArticleArchives> getArticleYearByTag(String article_tag);
}
