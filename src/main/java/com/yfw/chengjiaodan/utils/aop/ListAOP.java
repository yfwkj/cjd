package com.yfw.chengjiaodan.utils.aop;



import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.utils.PagingUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ControllerAOP
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/3 16:54
 * @Version: 1.0
 **/
@Component
@Aspect
@Slf4j
public class ListAOP extends BaseApiService<JSONObject> {

    @Pointcut("execution(* com.yfw.chengjiaodan.service.impl.*.*List(..))")
    public void Pointcut() {

    }

    @Around("Pointcut()")
    public BaseResponse<JSONObject> doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object arg = proceedingJoinPoint.getArgs()[0];
        JSONObject values = (JSONObject) JSONObject.toJSON(arg);
        String page = values.getString("page");
        Integer pageInt = PagingUtil.DEFAULT_PAGE;
        if (!StringUtils.isEmpty(page)) {
            pageInt = Integer.parseInt(page);
        }
        String size = values.getString("size");
        Integer sizeInt = PagingUtil.DEFAULT_SIZE;
        if (!StringUtils.isEmpty(size)) {
            sizeInt = Integer.parseInt(size);
        }
        String sortJson = values.getString("sort");
        String sort = PagingUtil.DEFAULT_SORT;
        if(!StringUtils.isEmpty(sortJson)){
            sort = sortJson;
        }
        JSONObject search = values.getJSONObject("search");
        PageHelper.startPage(pageInt, sizeInt);
        String temp = "";
        Map<String, Object> searchMap = search.getInnerMap();
        List<Object> searchValueList = new ArrayList<>();
        for (String key : searchMap.keySet()) {
            if (!StringUtils.isEmpty(searchMap.get(key) + "")) {
                //拼接模糊查询
                temp += " AND " + key + " LIKE " + "'%" + searchMap.get(key) + "%'";
            }
        }
        if (StringUtils.isEmpty(sort)) {
            sort = "id";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sort", sort);
        jsonObject.put("temp", temp);
        Object[] o = {jsonObject};
        BaseResponse<JSONObject> responseJson = (BaseResponse<JSONObject>) proceedingJoinPoint.proceed(o);
        Map<String, Object> map = responseJson.getData().getInnerMap();
        PageInfo<Object> mapPageInfo = (PageInfo<Object>) map.get("data");
        jsonObject.remove("sort");
        jsonObject.put("pages", mapPageInfo.getPageSize());
        jsonObject.put("orders", sort);
        jsonObject.put("size", mapPageInfo.getPageSize());
        jsonObject.put("total", mapPageInfo.getTotal());
        jsonObject.put("current", mapPageInfo.getPageNum());
        jsonObject.put("records", mapPageInfo.getList());
        return setResult(200, "", jsonObject);
    }
}
