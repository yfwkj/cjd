package com.yfw.chengjiaodan.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CjdAttachController
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 15:49
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/cjd/cjdAttach")
@Slf4j
public class CjdAttachController extends BaseApiService<JSONObject> {

    @Autowired
    private YfwCjdAttachService yfwCjdAttachService;

    @RequestMapping("/addSubmit")
    public BaseResponse<JSONObject> addSubmit(@RequestBody @Validated YfwCjdAttachEntity yfwCjdAttachEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return setResultError(400, bindingResult.getFieldError().getDefaultMessage());
        }
        if (yfwCjdAttachService.addSubmit(yfwCjdAttachEntity)) {
            return setResult(200, "添加成功", null);
        }
        return setResultError(400, "添加失败");
    }

    /**
     * @return com.yfw.chengjiaodan.base.BaseResponse<com.alibaba.fastjson.JSONObject>
     * @Author Chenyz
     * @Description //TODO
     * @Date 17:37 2020/6/30
     * @Param [page 当前页, size 每天条数, sort 排序字段可多个可含desc, search 模糊查询关键字]
     **/
    @RequestMapping("/list")
    public BaseResponse<JSONObject> list(@RequestBody JSONObject values) {
        Integer page = Integer.parseInt(values.get("page") + "");
        Integer size = Integer.parseInt(values.get("size") + "");
        String sort = values.get("sort") + "";
        List<Map<String, Object>> listMap =
                yfwCjdAttachService.findYfwCjdAttach(page, size, sort);
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(listMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Pages", page);
        jsonObject.put("Orders", "");
        jsonObject.put("Size", mapPageInfo.getSize());
        jsonObject.put("Total", mapPageInfo.getTotal());
        jsonObject.put("Current", 1);
        jsonObject.put("Records", mapPageInfo.getList());
        return setResult(200, "", jsonObject);
    }

}
