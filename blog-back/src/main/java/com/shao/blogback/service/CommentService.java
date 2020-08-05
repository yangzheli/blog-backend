package com.shao.blogback.service;

import com.shao.blogback.model.Comments;
import com.shao.blogback.model.ResponseBase;

import java.util.List;

public interface CommentService {
    List<Comments> getCommentsByArticleId(Integer article_id);

    ResponseBase saveComment(Comments comments);
}
