package com.yfw.chengjiaodan.service;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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

    /**
     * @Author Chenyz
     * @Description 修改  yfw_cjd_yjbl del 字段 0 表示正常 1 表示删除
     * @Date 15:36 2020/7/3
     * @Param [id]
     * @return java.lang.Integer
     **/
    Boolean moveCjdYjblById(JSONObject id);
}
