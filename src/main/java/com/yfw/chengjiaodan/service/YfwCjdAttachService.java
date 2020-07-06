package com.yfw.chengjiaodan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YfwCjdAttachService {

    Boolean addSubmit(YfwCjdAttachEntity yfwCjdAttachEntity);

    StaffVoEntity findStaff(@Param("id") String id);

    /**
     * @Author Chenyz
     * @Description 更改 del 字段状态
     * @Date 14:44 2020/7/3
     * @Param [id]
     * @return java.lang.Boolean
     **/
    Boolean moveCjdAttachById(JSONObject id);

    BaseResponse<JSONObject> findYfwCjdAttachList(JSONObject values);
}
