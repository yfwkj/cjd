package com.yfw.chengjiaodan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: CjdAttachController
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 15:49
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/cjd/cjdAttach")
public class CjdAttachController extends BaseApiService<JSONObject> {

    @Autowired
    private YfwCjdAttachService yfwCjdAttachService;

    @RequestMapping("/addSubmit")
    public BaseResponse<JSONObject> addSubmit(@RequestBody YfwCjdAttachEntity yfwCjdAttachEntity){
        if(yfwCjdAttachService.addSubmit(yfwCjdAttachEntity)){
            return setResult(200,"添加成功",null);
        }
        return setResultError(400,"添加失败");
    }

}
