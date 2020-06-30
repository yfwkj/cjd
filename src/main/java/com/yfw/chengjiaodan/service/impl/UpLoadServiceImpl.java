package com.yfw.chengjiaodan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.service.UpLoadService;
import com.yfw.chengjiaodan.utils.RestTempLateUpLoadFDW;
import com.yfw.chengjiaodan.utils.ThumbnailsUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName: UpLoadServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/30 17:20
 * @Version: 1.0
 **/
@Service
public class UpLoadServiceImpl extends BaseApiService<JSONObject> implements UpLoadService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BaseResponse<JSONObject> upload(MultipartFile file) {

        if (file == null)
            return setResultError("上传失败，上传附件不能为空");

        String result = RestTempLateUpLoadFDW.getRresponseBody(file, restTemplate);

        JSONObject data1 = JSONObject.parseObject(result);
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
            ThumbnailsUtil.setThumbnails(file.getInputStream(),scale,quality,outFilePath);
            localFile = new File(outFilePath);
            inputStream = new FileInputStream(localFile);
            System.out.println(localFile.getName());
            thumbnailsFile = new MockMultipartFile(localFile.getName(), localFile.getName(), file.getContentType(), inputStream);
            result = RestTempLateUpLoadFDW.getRresponseBody(thumbnailsFile, restTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            return setResultError("上传失败");
        }

        JSONObject data2 = JSONObject.parseObject(result);
        JSONObject src2 = JSONObject.parseObject(data2.get("data") + "");

        JSONObject value = new JSONObject();
        value.put("src", src1.get("src"));
        value.put("thumbnail", src2.get("src"));
        return setResult(200, "上传成功", value);
    }
}
