package com.shao.blogback.controller;

import com.shao.blogback.common.ValidateCode;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = "生成随机验证码接口")
public class ValidateCodeController {

    @GetMapping("common/validate")
    public void validate(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expire", "0");
        response.setHeader("Pragma", "no-cache");

        ValidateCode validateCode = new ValidateCode();
        //返回图片
        validateCode.getRandomImage(request, response);
    }
}
