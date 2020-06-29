package com.yfw.chengjiaodan.controller;


import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


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
public class UpdateController extends BaseApiService<JSONObject> {

    @Resource
    private ResourceLoader resourceLoader;

    @RequestMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {

        try {
            multipartFile.transferTo(new File(multipartFile.getOriginalFilename()));
            String path = request.getRequestURL() + "/" + multipartFile.getOriginalFilename();

            JSONObject value = new JSONObject();
            value.put("src",path);
            value.put("thumbnail","");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("data",value);
            return setResult(200, "上传成功", jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return setResultError("上传失败");
    }


}
