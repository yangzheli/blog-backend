package com.shao.blogback.controller;

import com.shao.blogback.model.Comments;
import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "文章评论相关接口")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @ApiOperation("获取文章评论接口")
    @GetMapping("comment/getCommentsByArticleId")
    public List<Comments> getCommentsByArticleId(Integer article_id) {
        return commentService.getCommentsByArticleId(article_id);
    }

    @ApiOperation("保存用户评论接口")
    @PostMapping("comment/saveComment")
    public ResponseBase saveComment(Comments comments) {
        return commentService.saveComment(comments);
    }
}
