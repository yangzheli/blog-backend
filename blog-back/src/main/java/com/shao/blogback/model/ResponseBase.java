package com.shao.blogback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回消息工具类
 */
@Data
@NoArgsConstructor
public class ResponseBase {
    private Integer code;//消息码
    private String msg;//消息描述
    private Object data;//具体的消息内容
    private String token;//登录后token

    public static final Integer SUCCESS = 1;
    public static final Integer ERROR = 0;

    public ResponseBase(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *  带token的返回消息
     */
    public ResponseBase(Integer code, String msg, Object data, String token) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.token = token;
    }
}
