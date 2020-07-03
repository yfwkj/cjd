package com.yfw.chengjiaodan.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import com.yfw.chengjiaodan.service.YfwCjdYjblService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public BaseResponse<JSONObject> addSubmit(@RequestBody YfwCjdYjblEntity yfwCjdYjblEntity) {
        log.info("/cjd/cjdbili/addSubmit");
        if (!yfwCjdYjblService.addSubmit(yfwCjdYjblEntity)) {
            return setResultError("添加失败");
        }
        return setResultSuccess("添加成功");
    }

    @PostMapping("/list")
    public BaseResponse<JSONObject> list(@RequestBody JSONObject values) {
        log.info("/cjd/cjdbili/list");
        String orders = "正序";
        String page = values.getString("page");
        Integer pageInt = 0;
        if (!StringUtils.isEmpty(page)) {
            pageInt = Integer.parseInt(page);
        }
        String size = values.getString("size");
        Integer sizeInt = 5;
        if (!StringUtils.isEmpty(size)) {
            sizeInt = Integer.parseInt(size);
        }
        String sort = values.getString("sort");
        String temp = sort;
        if(temp.contains(" ")){
            temp = sort.substring(sort.indexOf(" ")).replaceAll(" ","");
        }
        if("desc".equals(temp) || "DESC".equals(temp)){
            orders = "倒序";
        }
        JSONObject search = values.getJSONObject("search");
        List<YfwCjdYjblEntity> listYfwCjdYjblEntity =
                yfwCjdYjblService.findYfwCjdYjbl(pageInt, sizeInt, sort, search);
        log.info(listYfwCjdYjblEntity.toString());
        PageInfo<YfwCjdYjblEntity> mapPageInfo = new PageInfo<>(listYfwCjdYjblEntity);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pages", page);
        jsonObject.put("orders", orders);
        jsonObject.put("size", mapPageInfo.getSize());
        jsonObject.put("total", mapPageInfo.getTotal());
        jsonObject.put("current", mapPageInfo.getPageNum() + 1);
        jsonObject.put("records", mapPageInfo.getList());
        return setResult(200, "", jsonObject);
    }

}
