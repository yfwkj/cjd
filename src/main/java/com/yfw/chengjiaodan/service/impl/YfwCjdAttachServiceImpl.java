package com.yfw.chengjiaodan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.YfwCjdAttachMapper;
import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: YfwCjdAttachServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 15:53
 * @Version: 1.0
 **/
@Service
@Slf4j
public class YfwCjdAttachServiceImpl extends BaseApiService<JSONObject> implements YfwCjdAttachService {

    @Autowired
    private YfwCjdAttachMapper yfwCjdAttachMapper;

    @Override
    public Boolean addSubmit(YfwCjdAttachEntity yfwCjdAttachEntity) {
        if(StringUtils.isEmpty(yfwCjdAttachEntity.getFileType())){
            yfwCjdAttachEntity.setFileType("0");
        }
        return yfwCjdAttachMapper.insertYfwCjdAttach(yfwCjdAttachEntity) > 0 ? true : false;
    }


    @Override
    public StaffVoEntity findStaff(String id) {
        return yfwCjdAttachMapper.selectStaff(id);
    }

    /**
     * @Author Chenyz
     * @Description 修改表del 字段状态
     * @Date 14:45 2020/7/3
     * @Param [id]
     * @return java.lang.Boolean
     **/
    @Override
    public Boolean moveCjdAttachById(JSONObject id) {
        if(id == null){
            return false;
        }
        String jsonId = id.getString("id");
        if(StringUtils.isEmpty(jsonId))
            jsonId = "0";
        return yfwCjdAttachMapper.updateCjdAttachById(jsonId) > 0 ? true : false;
    }


    public BaseResponse<JSONObject> findYfwCjdAttachList(JSONObject values) {
        String sort = values.getString("sort");
        String temp = values.getString("temp");
        List<YfwCjdAttachEntity> yfwCjdAttachList = yfwCjdAttachMapper.selectYfwCjdAttachPagehelper(sort, temp);
        PageInfo<YfwCjdAttachEntity> mapPageInfo = new PageInfo<>(yfwCjdAttachList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",mapPageInfo);
        return setResult(200,"成功",jsonObject);
    }
}
