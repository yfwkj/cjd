package com.yfw.chengjiaodan.controller;


import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.constants.Constants;
import com.yfwkj.jsb.mapper.entity.YfwCjd;
import com.yfw.chengjiaodan.service.YfwCjdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
public class YfwCjdController extends BaseApiService<YfwCjd> {

    @Autowired
    private YfwCjdService yfwCjdService;


    /**
     * @return com.base.BaseResponse<com.mapper.entity.YfwCjd>
     * @Author Chenyz
     * @Description yfwcjd 表添加并返回 单条记录接口
     * @Date 11:09 2020/6/28
     * @Param [yfwCjd, bindingResult]
     **/
    @RequestMapping("/addSubmit")
    public BaseResponse<YfwCjd> addSubmit(@RequestBody @Validated YfwCjd yfwCjd, BindingResult bindingResult) {
        //验证实体类参数
        if (bindingResult.hasErrors()) {
            return setResultError(Constants.HTTP_RES_CODE_500, bindingResult.getFieldError().getDefaultMessage());
        }
        //服务层返回业务结果
        BaseResponse<YfwCjd> yfwCjdEntityResult = yfwCjdService.addSubmit(yfwCjd);

        return setResult(yfwCjdEntityResult.getCode(), yfwCjdEntityResult.getMessage(), yfwCjdEntityResult.getData());
    }

//    @PostMapping("/list")
//    public BaseResponse<JSObject> list(@RequestBody JSONObject paramJSON) {
//        Integer page = paramJSON.getInteger("page");
//        Integer size = paramJSON.getInteger("size");
//        String sort = paramJSON.getString("sort");
//        JSONObject search = paramJSON.getJSONObject("search");
//        List<Map<String, Object>> yfwCjdList = yfwCjdService.findYfwCjdList(page, size, sort);
//        PageInfo yfwCjdListInfo = new PageInfo<Map<String, Object>>(yfwCjdList);
//
//        return null;
//    }


}
