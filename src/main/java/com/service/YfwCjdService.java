package com.service;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseResponse;
import com.mapper.entity.YfwCjdEntity;
import org.springframework.validation.BindingResult;

public interface YfwCjdService {

    //    BaseResponse<JSONObject> addSubmit(YfwCjdEntity yfwCjdEntity);
    BaseResponse<YfwCjdEntity> addSubmit(YfwCjdEntity yfwCjdEntity);
}
