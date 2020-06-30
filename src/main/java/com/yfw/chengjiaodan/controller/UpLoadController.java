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

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestBody MultipartFile file, HttpServletRequest request) {

        if (file == null)
            return setResultError("上传失败，上传附件不能为空");
        JSONObject value = new JSONObject();
        ResponseEntity<String> stringResponseEntity = null;

        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> parts1 = new LinkedMultiValueMap<>();
        //log.info(multipartFile.getOriginalFilename());
        parts1.add("file", file.getResource());
//        parts.add("file", thumbnailsFile.getResource());
        HttpEntity<MultiValueMap<String, Object>> httpEntity1 = new HttpEntity<>(parts1, headers1);
        stringResponseEntity = restTemplate.postForEntity("http://www.fangdianwang.com:8082/uploadfile/upload", httpEntity1, String.class);
        JSONObject data1 = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONObject src1 = JSONObject.parseObject(data1.get("data") + "");

        InputStream inputStream = null;
        File localFile = null;
        MultipartFile thumbnailsFile = null;

        //缩放比例
        Double scale = 0.1;
        //图片质量
        Float quality = 1.0f;
        //图片输出路径
        String outFilePath = "E:/sundry/uploadfile/thumbnails.jpg";

        try {

            Thumbnails.of(file.getInputStream()).scale(0.1f).outputQuality(1.0f).toFile(outFilePath);
            localFile = new File(outFilePath);
            inputStream = new FileInputStream(localFile);
            System.out.println(localFile.getName());
            thumbnailsFile = new MockMultipartFile(localFile.getName(), localFile.getName(), file.getContentType(), inputStream);
            thumbnailsFile.transferTo(new File("E:/sundry/uploadfile/test.jpg"));

            HttpHeaders headers2 = new HttpHeaders();
            headers2.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> parts2 = new LinkedMultiValueMap<>();
            //log.info(multipartFile.getOriginalFilename());
            parts2.add("file", thumbnailsFile.getResource());
            HttpEntity<MultiValueMap<String, Object>> httpEntity2 = new HttpEntity<>(parts2, headers2);
            stringResponseEntity = restTemplate.postForEntity("http://www.fangdianwang.com:8082/uploadfile/upload", httpEntity2, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject data2 = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONObject src2 = JSONObject.parseObject(data2.get("data") + "");

        value.put("src", src1.get("src"));
        value.put("thumbnail", src2.get("src"));
        return setResult(200, "上传成功", value);
    }


}
