package com.example.demo.controller;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author LYL
 * @create 2021/5/21 17:40
 */
@RestController
public class FileUploadController {
    @Value("${file.root.path}")
    private String fileRootPath;

    @PostMapping("/file/upload")
    public String fileUpload(@RequestParam("files") MultipartFile[] files){
        String filePath = "";

        // 多文件上传
        for (MultipartFile file : files){
            // 上传简单文件名
            String originalFilename = file.getOriginalFilename();
            //判断字符串前缀
            if (originalFilename.startsWith("1")){
                System.out.println("1");
            }else if (originalFilename.startsWith("0")){
                System.out.println("0");
            }else if (originalFilename.startsWith("r")){
                System.out.println("r");
            }
            // 存储路径
            filePath = new StringBuilder(fileRootPath)
                    .append(System.currentTimeMillis())
                    .append(originalFilename)
                    .toString();
            try {
                if (file.isEmpty()){
                    continue;
                }else {
                    // 保存文件
                    file.transferTo(new File(filePath));
                }
            }catch (IOException e){
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "提交成功";
    }

}
