package com.yfw.chengjiaodan.controller;



import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;


/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 9:29
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/file")
public class UpdateController {

    private String uploadPicturePath = "E:/sundry/uploadfile";

    @Resource
    private ResourceLoader resourceLoader;

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile){
        try {
            multipartFile.transferTo(new File(multipartFile.getOriginalFilename()));
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
