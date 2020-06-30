package com.yfw.chengjiaodan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: RestTempLateUpLoadFDW
 * @Description: RPC 访问 http://www.fangdianwang.com:8082/uploadfile/upload 上传文件并返回结果
 * @Author: Chenyz
 * @Date: 2020/6/30 16:51
 * @Version: 1.0
 **/
public class RestTempLateUpLoadFDW {


    public static String getRresponseBody(MultipartFile file, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        //log.info(multipartFile.getOriginalFilename());
        parts.add("file", file.getResource());
        //        parts.add("file", thumbnailsFile.getResource());
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(parts, headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://www.fangdianwang.com:8082/uploadfile/upload", httpEntity, String.class);
        return stringResponseEntity.getBody();
    }

}
