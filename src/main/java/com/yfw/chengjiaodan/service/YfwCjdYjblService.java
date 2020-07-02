package com.yfw.chengjiaodan.service;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;

import java.util.List;

public interface YfwCjdYjblService {

    /**
     * @Author Chenyz
     * @Description 添加
     * @Date 16:54 2020/7/2
     * @Param [yfwCjdYjblEntity]
     * @return java.lang.Boolean
     **/
    Boolean addSubmit(YfwCjdYjblEntity yfwCjdYjblEntity);

    List<YfwCjdYjblEntity> findYfwCjdYjbl(Integer page, Integer size, String sort, JSONObject search);
}
