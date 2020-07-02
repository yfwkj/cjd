package com.yfw.chengjiaodan.service.impl;



import com.github.pagehelper.PageHelper;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.constants.Constants;
import com.yfw.chengjiaodan.mapper.YfwCjdMapper;
import com.yfw.chengjiaodan.mapper.YfwConfigMapper;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdEntity;
import com.yfw.chengjiaodan.service.YfwCjdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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
    @Transactional
    public BaseResponse<YfwCjdEntity> addSubmit(YfwCjdEntity yfwCjdEntity) {

        //.验证对象
        if (yfwCjdEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_201, "参数对象为空");
        }
        //查询yfwConfig表里的value 字段值
        String yfwConfigValue = yfwConfigMapper.selectYfwConfigValue();
        int result = Integer.parseInt(yfwConfigValue);
        //更新value值
        result += 1;
        if(yfwConfigMapper.updateYfwConfigValue(result + "") <= 0){
            return setResultError("更新value值失败");
        }
        String stringFormat = String.format("C%010d", result);
        yfwCjdEntity.setCjNo(stringFormat);
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

    @Override
    public List<Map<String, Object>> findYfwCjdList(Integer page,Integer size,String sort) {
        PageHelper.startPage(page,size);
        return yfwCjdMapper.selectYfwCjdList(sort);
    }


}
