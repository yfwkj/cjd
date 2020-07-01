package com.yfw.chengjiaodan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yfw.chengjiaodan.mapper.YfwCjdAttachMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        System.out.println(Integer.parseInt(yfwCjdAttachEntity.getFileType()));
        return yfwCjdAttachMapper.insertYfwCjdAttach(yfwCjdAttachEntity) > 0 ? true : false;
    }

    @Override
    public List<Map<String, Object>> findYfwCjdAttach(Integer page, Integer size, String sort, JSONObject search) {
        //search = {"created_by":"abc","url":"http://///"}
        //1.json 转成 map
        //2.遍历map 获得key and value
        //3.检查value 不为空, a = a + " and key like value"
        String temp = "";
        Map<String, Object> searchMap = search.getInnerMap();
        List<Object> searchValueList = new ArrayList<>();
        for (String key : searchMap.keySet()) {
            if(!StringUtils.isEmpty(searchMap.get(key) + "")){
                temp += " AND " + key +" LIKE "+ "'%" + searchMap.get(key) + "%'" ;
            }
        }


        PageHelper.startPage(page,size);
        return yfwCjdAttachMapper.selectYfwCjdAttachPagehelper(sort,temp);
    }

}
