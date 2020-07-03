package com.yfw.chengjiaodan.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yfw.chengjiaodan.mapper.YfwCjdYjblMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: YfwCjdYjblServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 11:22
 * @Version: 1.0
 **/
@Service
public class YfwCjdYjblServiceImpl implements YfwCjdYjblService {

    @Autowired
    private YfwCjdYjblMapper yfwCjdYjblMapper;

    @Override
    public Boolean addSubmit(YfwCjdYjblEntity yfwCjdYjblEntity) {
        return yfwCjdYjblMapper.insertYfwCjdYjbl(yfwCjdYjblEntity) > 0 ? true : false;
    }


    /**
     * @return java.util.List<com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity>
     * @Author Chenyz
     * @Description 分页  模糊查询  排序
     * @Date 16:54 2020/7/2
     * @Param [page, size, sort, search]
     **/
    @Override
    public List<YfwCjdYjblEntity> findYfwCjdYjbl(Integer page, Integer size, String sort, JSONObject search) {
        PageHelper.startPage(page, size);
        String temp = "";
        Map<String, Object> searchMap = search.getInnerMap();
        List<Object> searchValueList = new ArrayList<>();
        for (String key : searchMap.keySet()) {
            if (!StringUtils.isEmpty(searchMap.get(key) + "")) {
                //拼接模糊查询
                temp += " AND " + key + " LIKE " + "'%" + searchMap.get(key) + "%'";
            }
        }
        if (StringUtils.isEmpty(sort)) {
            sort = "id";
        }
        return yfwCjdYjblMapper.selectYfwCjdYjblPagehelper(sort, temp);
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
}
