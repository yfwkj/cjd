package com.yfw.chengjiaodan.service.impl;


import com.yfw.chengjiaodan.mapper.YfwCjdYjblMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
