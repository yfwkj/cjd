package com.yfw.chengjiaodan.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yfw.chengjiaodan.mapper.YfwCjdYjblMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import org.apache.commons.lang3.StringUtils;
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
     * @Author Chenyz
     * @Description 分页  模糊查询  排序
     * @Date 16:54 2020/7/2
     * @Param [page, size, sort, search]
     * @return java.util.List<com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity>
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
        if(StringUtils.isEmpty(sort)){
            sort = "id";
        }
        return yfwCjdYjblMapper.selectYfwCjdYjblPagehelper(sort, temp);
    }
}
