package com.shao.blogback.dao;

import com.shao.blogback.model.Comments;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {
    @Select("SELECT c.*, u.username, u.avatar FROM comment c INNER JOIN USER u ON c.userId = u.userId where article_id = #{article_id} ORDER BY comment_time DESC")
    List<Comments> getCommentsByArticleId(Integer article_id);

    @Insert("INSERT INTO comment (article_id,userId,comments) VALUES (#{article_id},#{userId},#{comments})")
    void saveComment(Comments comments);
}
