package com.shao.blogback.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Comments {
    private int article_id;
    private int userId;
    private String username;
    private String avatar;//用户头像URL
    private String comments;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date comment_time;
}
