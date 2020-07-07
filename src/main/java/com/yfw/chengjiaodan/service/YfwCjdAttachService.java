package com.yfw.chengjiaodan.service;


import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfwkj.jsb.mapper.entity.YfwCjdAttach;
import org.apache.ibatis.annotations.Param;

public interface YfwCjdAttachService {

    Boolean addSubmit(YfwCjdAttach yfwCjdAttach);

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
