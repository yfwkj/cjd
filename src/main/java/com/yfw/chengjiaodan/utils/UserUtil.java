package com.yfw.chengjiaodan.utils;

import com.alibaba.fastjson.JSONObject;
import com.chtwm.component.util.JwtHelper;
import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: UserUtil
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 16:41
 * @Version: 1.0
 **/
public class UserUtil {

    public static StaffVoEntity getTokenStaff(YfwCjdAttachService yfwCjdAttachService) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        String jwt = request.getHeader("User-Token");
        String retJson = JwtHelper.validateLogin(jwt);
        JSONObject jsonObject = JSONObject.parseObject(retJson);
        if(jsonObject == null){
            return null;
        }
        Integer userId = jsonObject.getInteger("userId");
        return yfwCjdAttachService.findStaff(userId + "");


    }
}
