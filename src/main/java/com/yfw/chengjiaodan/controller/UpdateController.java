package com.yfw.chengjiaodan.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.utils.ThumbnailsUtil;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.makers.ThumbnailMaker;
import net.coobird.thumbnailator.util.ThumbnailatorUtils;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Value("${spring.servlet.multipart.location}")
    private String location;

    @RequestMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String currentTimeMillis = dateFormat.format(new Date(System.currentTimeMillis()));
        try {
            multipartFile.transferTo(new File(currentTimeMillis + ".jpg"));
            String path = request.getRequestURL() + "/" + multipartFile.getOriginalFilename();
            //源图片路径
            String sourceFile = location + "/" + currentTimeMillis + ".jpg";
            //缩放比例
            Double scale = 0.1;
            //图片质量
            Float quality = 1.0f;
            //图片输出路径
            String outFilePath = location + "/" + currentTimeMillis + "thumbnails.jpg";
            ThumbnailsUtil.setThumbnails(sourceFile,scale,quality,outFilePath);
            JSONObject value = new JSONObject();
            value.put("src",path);
            value.put("thumbnail","");
            return setResult(200, "上传成功", value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return setResultError("上传失败");
    }


}
