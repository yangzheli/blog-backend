package com.shao.blogback.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private int article_id;
    private int user_id;
    private String article_title;
    private String article_content;
    private String article_tags;//文章标签
    private int create_year;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
}
