package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseApiService;
import com.base.BaseResponse;
import com.mapper.entity.YfwCjdEntity;
import com.service.YfwCjdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexController extends BaseApiService<JSONObject> {

    @Autowired
    private YfwCjdService yfwCjdService;

    @RequestMapping("/addSubmit")
    public BaseResponse<JSONObject> addSubmit(@RequestBody YfwCjdEntity yfwCjdEntity) {

        log.info("<<<<<<<<<<<<<<");
        //服务层返回业务结果
        BaseResponse<JSONObject> yfwCjdEntityJson = yfwCjdService.addSubmit(yfwCjdEntity);

        return setResult(yfwCjdEntityJson.getCode(), yfwCjdEntityJson.getMsg(), yfwCjdEntityJson.getData().getJSONObject("resultMap"));
    }
}
