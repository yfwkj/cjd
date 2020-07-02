package com.yfw.chengjiaodan.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import com.yfw.chengjiaodan.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        log.info("/cjd/cjdAttach/addSubmit");
        StaffVoEntity staff =  UserUtil.getTokenStaff(yfwCjdAttachService);
        if(staff == null){
            return setResultError("可能因为token已经超时或非法token");
        }
        yfwCjdAttachEntity.setCreatedBy(staff.getName());
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
        log.info("/cjd/cjdAttach/list");
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
//        orders = sort.substring(sort.indexOf(" ")).replaceAll(" ","");
//        if("desc".equals(orders) || "DESC".equals(orders)){
//            orders = "倒序";
//        }
        JSONObject search = values.getJSONObject("search");
        List<YfwCjdAttachEntity> listYfwCjdAttach =
                yfwCjdAttachService.findYfwCjdAttach(pageInt, sizeInt, sort, search);
        log.info(listYfwCjdAttach.toString());
        PageInfo<YfwCjdAttachEntity> mapPageInfo = new PageInfo<>(listYfwCjdAttach);
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
