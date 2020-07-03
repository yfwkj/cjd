package com.yfw.chengjiaodan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
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
public class YfwCjdAttachServiceImpl implements YfwCjdAttachService {

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
    public List<YfwCjdAttachEntity> findYfwCjdAttach(Integer page, Integer size, String sort, JSONObject search) {
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
        return yfwCjdAttachMapper.selectYfwCjdAttachPagehelper(sort, temp);
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

}
