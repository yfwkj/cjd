package com.yfw.chengjiaodan.service.impl;

import com.github.pagehelper.PageHelper;
import com.yfw.chengjiaodan.mapper.YfwCjdAttachMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: YfwCjdAttachServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 15:53
 * @Version: 1.0
 **/
@Service
public class YfwCjdAttachServiceImpl implements YfwCjdAttachService {

    @Autowired
    private YfwCjdAttachMapper yfwCjdAttachMapper;

    @Override
    public Boolean addSubmit(YfwCjdAttachEntity yfwCjdAttachEntity) {
        System.out.println(Integer.parseInt(yfwCjdAttachEntity.getFileType()));
        return yfwCjdAttachMapper.insertYfwCjdAttach(yfwCjdAttachEntity) > 0 ? true : false;
    }

    @Override
    public List<Map<String, Object>> findYfwCjdAttach(Integer page, Integer size,String sort) {
        PageHelper.startPage(page,size);
        return yfwCjdAttachMapper.selectYfwCjdAttachPagehelper(sort);
    }

    public Integer findYfwCjdAttachSize(){
        return yfwCjdAttachMapper.selectYfwCjdAttachSize();
    }
}
