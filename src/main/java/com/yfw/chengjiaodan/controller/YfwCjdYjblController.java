package com.yfw.chengjiaodan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: YfwCjdYjblController
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 11:24
 * @Version: 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/cjd/cjdbili")
public class YfwCjdYjblController extends BaseApiService<JSONObject> {

    @Autowired
    private YfwCjdYjblService yfwCjdYjblService;

    @PostMapping("/addSubmit")
    public BaseResponse<JSONObject> addSubmit(@RequestBody YfwCjdYjblEntity yfwCjdYjblEntity){
        log.info("/cjd/cjdbili/addSubmit");
        if(!yfwCjdYjblService.addSubmit(yfwCjdYjblEntity)){
            return setResultError("添加失败");
        }
        return setResultSuccess("添加成功");
    }

}
