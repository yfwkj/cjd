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
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;
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

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/upload")
    public BaseResponse<JSONObject> upload(@RequestBody MultipartFile file, HttpServletRequest request) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String currentTimeMillis = dateFormat.format(new Date(System.currentTimeMillis()));
        try {
            if(null == file){
                return setResultError("上传失败，上传附件不能为空");
            }
            file.transferTo(new File(currentTimeMillis + ".jpg"));
            String path = request.getRequestURL() + "/" + currentTimeMillis + ".jpg";
            //源图片路径
            String sourceFile = location + "/" + currentTimeMillis + ".jpg";
            //缩放比例
            Double scale = 0.1;
            //图片质量
            Float quality = 1.0f;
            //图片输出路径
            String outFilePath = location + "/" + currentTimeMillis + "thumbnails.jpg";
            //缩略图
            //ThumbnailsUtil.setThumbnails(sourceFile,scale,quality,outFilePath);
            JSONObject value = new JSONObject();


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            //log.info(multipartFile.getOriginalFilename());
            parts.add("file", file.getResource());
            HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(parts, headers);
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://www.fangdianwang.com:8082/uploadfile/upload", httpEntity, String.class);
            String replace = stringResponseEntity.getBody();



            value.put("src",path);
            value.put("thumbnail",outFilePath);

            return setResult(200, "上传成功", value);
        } catch (Exception e) {
            e.printStackTrace();
            return setResultError("上传失败");
        }

    }


}
