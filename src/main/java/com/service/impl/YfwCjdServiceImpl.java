package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseApiService;
import com.base.BaseResponse;
import com.constants.Constants;
import com.mapper.YfwCjdMapper;
import com.mapper.entity.YfwCjdEntity;
import com.service.YfwCjdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName: YfwCjdServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 9:01
 * @Version: 1.0
 **/
@Service
public class YfwCjdServiceImpl extends BaseApiService<JSONObject> implements YfwCjdService {

    @Autowired
    private YfwCjdMapper yfwCjdMapper;


    @Override
    public BaseResponse<JSONObject> addSubmit(YfwCjdEntity yfwCjdEntity) {
        //.验证对象
        //.逻辑判断
        if (yfwCjdEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_201, "参数对象为空");
        }
        //.访问数据库
        if (yfwCjdMapper.insertSubmit(yfwCjdEntity) <= 0) {
            return setResultError(Constants.HTTP_RES_CODE_500, "添加失败");
        }
        //返回添加ID 查询记录
        Map<String, Object> resultMap = yfwCjdMapper.selectYfwCjdEntity(yfwCjdEntity.getId());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resultMap", resultMap);
        if (resultMap == null) {
            return setResultError(Constants.HTTP_RES_CODE_500, "查询无数据");
        }
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, jsonObject);

    }
}
