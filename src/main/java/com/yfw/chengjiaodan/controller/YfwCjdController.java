package com.yfw.chengjiaodan.controller;


import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.constants.Constants;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdEntity;
import com.yfw.chengjiaodan.service.YfwCjdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 9:04
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/yfwcjd")
@Slf4j
public class YfwCjdController extends BaseApiService<YfwCjdEntity> {

    @Autowired
    private YfwCjdService yfwCjdService;


    /**
     * @Author Chenyz
     * @Description yfwcjd 表添加并返回 单条记录接口
     * @Date 11:09 2020/6/28
     * @Param [yfwCjdEntity, bindingResult]
     * @return com.base.BaseResponse<com.mapper.entity.YfwCjdEntity>
     **/
    @RequestMapping("/addSubmit")
    public BaseResponse<YfwCjdEntity> addSubmit(@RequestBody @Validated YfwCjdEntity yfwCjdEntity, BindingResult bindingResult) {
        log.info("<<<<<<<<<<<<<<");
        //验证实体类参数
        if(bindingResult.hasErrors()){
            return setResultError(Constants.HTTP_RES_CODE_500,bindingResult.getFieldError().getDefaultMessage());
        }
        //服务层返回业务结果
        BaseResponse<YfwCjdEntity> yfwCjdEntityResult = yfwCjdService.addSubmit(yfwCjdEntity);

        return setResult(yfwCjdEntityResult.getCode(), yfwCjdEntityResult.getMessage(), yfwCjdEntityResult.getData());
    }




}
