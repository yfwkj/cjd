package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseApiService;
import com.base.BaseResponse;
import com.constants.Constants;
import com.mapper.entity.YfwCjdEntity;
import com.service.YfwCjdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class IndexController extends BaseApiService<YfwCjdEntity> {

    @Autowired
    private YfwCjdService yfwCjdService;

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
