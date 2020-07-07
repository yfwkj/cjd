package com.yfw.chengjiaodan.service.impl;


import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.YfwCjdYjblMapper;

import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import com.yfwkj.jsb.mapper.entity.YfwCjdYjbl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.List;


/**
 * @ClassName: YfwCjdYjblServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 11:22
 * @Version: 1.0
 **/
@Service
public class YfwCjdYjblServiceImpl extends BaseApiService<JSONObject> implements YfwCjdYjblService {

    @Autowired
    private YfwCjdYjblMapper yfwCjdYjblMapper;

    @Override
    public BaseResponse<JSONObject> addSubmit(@Validated YfwCjdYjbl yfwCjdYjbl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return setResultError(bindingResult.getFieldError().getDefaultMessage());
        }
        return null;
        //return yfwCjdYjblMapper.insertYfwCjdYjbl(yfwCjdYjblEntity) > 0 ? true : false;
    }

    /**
     * @return java.lang.Integer
     * @Author Chenyz
     * @Description 修改  yfw_cjd_yjbl del 字段 0 表示正常 1 表示删除
     * @Date 15:36 2020/7/3
     * @Param [id]
     **/
    @Override
    public Boolean moveCjdYjblById(JSONObject id) {
        if (id == null) {
            return false;
        }
        String jsonId = id.getString("id");
        if (StringUtils.isEmpty(jsonId))
            jsonId = "0";
        return yfwCjdYjblMapper.updateCjdYjblById(jsonId) > 0 ? true : false;
    }

    /**
     * @return java.util.List<com.yfwkj.jsb.mapper.entity.YfwCjdYjblEntity>
     * @Author Chenyz
     * @Description 分页  模糊查询  排序
     * @Date 16:54 2020/7/2
     * @Param [page, size, sort, search]
     **/
    public BaseResponse<JSONObject> findYfwCjdYjblList(JSONObject values){
        String sort = values.getString("sort");
        String temp = values.getString("temp");
        List<YfwCjdYjbl> yfwCjdYjblList = yfwCjdYjblMapper.selectYfwCjdYjblPagehelper(sort,temp);
        PageInfo<YfwCjdYjbl> mapPageInfo = new PageInfo<>(yfwCjdYjblList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",mapPageInfo);
        return setResult(200,"成功",jsonObject);
    }
}
