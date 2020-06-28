package com.service.impl;


import com.base.BaseApiService;
import com.base.BaseResponse;
import com.constants.Constants;
import com.mapper.YfwCjdMapper;
import com.mapper.YfwConfigMapper;
import com.mapper.entity.YfwCjdEntity;
import com.service.YfwCjdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @ClassName: YfwCjdServiceImpl
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 9:01
 * @Version: 1.0
 **/
@Service
public class YfwCjdServiceImpl extends BaseApiService<YfwCjdEntity> implements YfwCjdService {

    @Autowired
    private YfwCjdMapper yfwCjdMapper;

    @Autowired
    private YfwConfigMapper yfwConfigMapper;

    /**
     * @Author Chenyz
     * @Description 添加 yfwcjd 表 返回ID 查询添加成功的单条记录
     * @Date 11:08 2020/6/28
     * @Param [yfwCjdEntity]
     * @return com.base.BaseResponse<com.mapper.entity.YfwCjdEntity>
     **/
    @Override
    public BaseResponse<YfwCjdEntity> addSubmit(YfwCjdEntity yfwCjdEntity) {

        //.验证对象
        if (yfwCjdEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_201, "参数对象为空");
        }

        //.添加yfwcjd数据
        if (yfwCjdMapper.insertSubmit(yfwCjdEntity) <= 0) {
            return setResultError(Constants.HTTP_RES_CODE_500, "添加失败");
        }
        //返回添加ID 查询记录
        YfwCjdEntity yfwCjdEntityResult = yfwCjdMapper.selectYfwCjdEntity(yfwCjdEntity.getId());
        if (yfwCjdEntityResult == null) {
            return setResultError(Constants.HTTP_RES_CODE_500, "查询无数据");
        }
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, yfwCjdEntityResult);
    }




}
