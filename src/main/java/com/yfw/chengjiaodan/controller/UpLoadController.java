package com.yfw.chengjiaodan.controller;



import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;

import lombok.extern.slf4j.Slf4j;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.*;



/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 9:29
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/cjd/cjdAttach")
@Slf4j
public class UpLoadController extends BaseApiService<JSONObject> {

    //@Value("${spring.servlet.multipart.location}")
    //private String location;

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestBody MultipartFile file, HttpServletRequest request) {
        JSONObject value = new JSONObject();
        value.put("src", "src");
        value.put("thumbnail", "thumbnail");

        return setResult(200, "上传成功", value);

    }

//    @RequestMapping("/upload11")
//    public BaseResponse<JSONObject> upload11(@RequestBody MultipartFile file, HttpServletRequest request) {
//        if (file == null)
//            return setResultError("上传失败，上传附件不能为空");
//        InputStream in = null;
//        File file1 = null;
//        MultipartFile thumbnailsFile = null;
//        //缩放比例
//        Double scale = 0.1;
//        //图片质量
//        Float quality = 1.0f;
//        //图片输出路径
//        String outFilePath = "E:/sundry/uploadfile/thumbnails.jpg";
//        try {
//            Thumbnails.of(file.getInputStream()).scale(0.1f).outputQuality(1.0f).toFile(outFilePath);
//            file1 = new File(outFilePath);
//            in = new FileInputStream(file1);
//            thumbnailsFile = new MockMultipartFile(file1.getName(),in);
//            thumbnailsFile.transferTo(new File("E:/sundry/uploadfile/test.jpg"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
//        //log.info(multipartFile.getOriginalFilename());
//        parts.add("file", file.getResource());
//        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(parts, headers);
//        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://www.fangdianwang.com:8082/uploadfile/upload", httpEntity, String.class);
//        String replace = stringResponseEntity.getBody();
//
//        return null;
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
////        String currentTimeMillis = dateFormat.format(new Date(System.currentTimeMillis()));
////            JSONObject value = new JSONObject();
////            value.put("src",path);
////            value.put("thumbnail",outFilePath);
//
////            return setResult(200, "上传成功", value);
////
//
//    }


}
