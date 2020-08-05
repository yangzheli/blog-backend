package com.shao.blogback.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Api(tags = "文件上传相关接口")
public class UploadFileController {
    @ApiOperation("文件上传相关接口")
    @PostMapping("upload/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();//文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀名
        String filePath = "D:/blog/upload/";//上传后的路径
        fileName = UUID.randomUUID() + suffixName;//新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return "图片上传失败!";
        }
        String res = "/image/" + fileName;
        return res;
    }
}
