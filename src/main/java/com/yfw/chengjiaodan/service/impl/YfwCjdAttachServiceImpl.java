package com.yfw.chengjiaodan.service.impl;

import com.yfw.chengjiaodan.mapper.YfwCjdAttachMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return yfwCjdAttachMapper.insertYfwCjdAttach(yfwCjdAttachEntity) > 0 ? true : false;
    }
}
