package com.shao.blogback.service.impl;

import com.shao.blogback.dao.CommentDao;
import com.shao.blogback.model.Comments;
import com.shao.blogback.model.ResponseBase;
import com.shao.blogback.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comments> getCommentsByArticleId(Integer article_id) {
        return commentDao.getCommentsByArticleId(article_id);
    }

    @Override
    public ResponseBase saveComment(Comments comments) {
        commentDao.saveComment(comments);
        return new ResponseBase(ResponseBase.SUCCESS, "评论成功", null);
    }
}
