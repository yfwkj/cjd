package com.yfw.chengjiaodan.controller;


import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;

import com.yfw.chengjiaodan.service.UpLoadService;
import com.yfw.chengjiaodan.utils.RestTempLateUpLoadFDW;
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
    private UpLoadService upLoadService;

    @RequestMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestBody MultipartFile file) {
        return upLoadService.upload(file);
    }


}
