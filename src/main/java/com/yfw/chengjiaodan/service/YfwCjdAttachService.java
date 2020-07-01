package com.yfw.chengjiaodan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;

import java.util.List;
import java.util.Map;

public interface YfwCjdAttachService {

    Boolean addSubmit(YfwCjdAttachEntity yfwCjdAttachEntity);

    List<Map<String,Object>> findYfwCjdAttach(Integer page, Integer size, String sort, JSONObject search);

}
