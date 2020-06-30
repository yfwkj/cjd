package com.yfw.chengjiaodan.service;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UpLoadService {

    BaseResponse<JSONObject> upload(MultipartFile file);
}
