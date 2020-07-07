package com.yfw.chengjiaodan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import com.yfwkj.jsb.mapper.entity.YfwCjdYjbl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addSubmit")
    public BaseResponse<JSONObject> addSubmit(@RequestBody YfwCjdYjbl yfwCjdYjbl, BindingResult bindingResult) {
        log.info("/cjd/cjdbili/addSubmit");
//        if (!yfwCjdYjblService.addSubmit(yfwCjdYjblEntity,bindingResult)) {
//            return setResultError("添加失败");
//        }
//        return setResultSuccess("添加成功");
        return yfwCjdYjblService.addSubmit(yfwCjdYjbl,bindingResult);
    }

    @PostMapping("/list")
    public BaseResponse<JSONObject> list(@RequestBody JSONObject values) {
        BaseResponse<JSONObject> baseResponse = yfwCjdYjblService.findYfwCjdYjblList(values);
        return baseResponse;
    }

    @PostMapping("/del")
    public BaseResponse<JSONObject> del(@RequestBody JSONObject id){
        if(yfwCjdYjblService.moveCjdYjblById(id)){
            return setResultSuccess("删除成功");
        }
        return setResultError("删除失败");
    }


//    @PostMapping("/test")
//    public BaseResponse<JSONObject> test() {
//        log.info("/cjd/cjdbili/list");
//        JSONObject jsonObject = new JSONObject();
//
//        String url = "/cjd/cjdbili/list";
//        jsonObject.put("page","0");
//        jsonObject.put("size","5");
//        jsonObject.put("sort","");
//        jsonObject.put("search","{}");
//        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, jsonObject);
//
//
//        jsonObject.put("/cjd/cjdbili/list", result1);
//        return setResult(200, "", jsonObject);
//    }
}
