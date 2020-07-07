package com.yfw.chengjiaodan.controller;


import com.alibaba.fastjson.JSONObject;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import com.yfw.chengjiaodan.utils.UserUtil;
import com.yfwkj.jsb.mapper.entity.YfwCjdAttach;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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
@Slf4j
public class CjdAttachController extends BaseApiService<JSONObject> {

    @Autowired
    private YfwCjdAttachService yfwCjdAttachService;

    @RequestMapping("/addSubmit")
    public BaseResponse<JSONObject> addSubmit(@RequestBody @Validated YfwCjdAttach yfwCjdAttach, BindingResult bindingResult) {
        log.info("/cjd/cjdAttach/addSubmit");
        StaffVoEntity staff = UserUtil.getTokenStaff(yfwCjdAttachService);
        if (staff == null) {
            return setResultError("可能因为token已经超时或非法token");
        }
        yfwCjdAttach.setCreatedBy(staff.getName());
        if (bindingResult.hasErrors()) {
            return setResultError(400, bindingResult.getFieldError().getDefaultMessage());
        }
        if (yfwCjdAttachService.addSubmit(yfwCjdAttach)) {
            return setResult(200, "添加成功", null);
        }
        return setResultError(400, "添加失败");
    }

    /**
     * @return com.yfw.chengjiaodan.base.BaseResponse<com.alibaba.fastjson.JSONObject>
     * @Author Chenyz
     * @Description 返回200成功 500失败
     * @Date 14:48 2020/7/3
     * @Param [id]
     **/
    @PostMapping("/del")
    public BaseResponse<JSONObject> del(@RequestBody JSONObject id) {
        if (yfwCjdAttachService.moveCjdAttachById(id)) {
            return setResultSuccess("删除成功");
        }
        return setResultError("删除失败");
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
        BaseResponse<JSONObject> baseResponse = yfwCjdAttachService.findYfwCjdAttachList(values);
        return baseResponse;
    }
}
