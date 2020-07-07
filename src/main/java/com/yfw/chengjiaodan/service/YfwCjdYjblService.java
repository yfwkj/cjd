package com.yfw.chengjiaodan.service;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfwkj.jsb.mapper.entity.YfwCjdYjbl;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

public interface YfwCjdYjblService {

    /**
     * @return java.lang.Boolean
     * @Author Chenyz
     * @Description 添加
     * @Date 16:54 2020/7/2
     * @Param [yfwCjdYjblEntity]
     **/
    BaseResponse<JSONObject> addSubmit(@Validated YfwCjdYjbl yfwCjdYjbl, BindingResult bindingResult);

    BaseResponse<JSONObject> findYfwCjdYjblList(JSONObject values);

    /**
     * @return java.lang.Integer
     * @Author Chenyz
     * @Description 修改  yfw_cjd_yjbl del 字段 0 表示正常 1 表示删除
     * @Date 15:36 2020/7/3
     * @Param [id]
     **/
    Boolean moveCjdYjblById(JSONObject id);
}
