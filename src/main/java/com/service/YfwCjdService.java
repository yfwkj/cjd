package com.service;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseResponse;
import com.mapper.entity.YfwCjdEntity;

public interface YfwCjdService {

    BaseResponse<JSONObject> addSubmit(YfwCjdEntity yfwCjdEntity);
}
