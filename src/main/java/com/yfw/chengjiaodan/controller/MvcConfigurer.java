package com.yfw.chengjiaodan.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 全局定制化Spring Boot的MVC特性
 *
 * @author lerry
 */
@Slf4j
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {





    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //使用阿里 FastJson 作为JSON MessageConverter
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        //保留空的字段
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        // 按需配置，更多参考FastJson文档
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    /**
     * 添加拦截器
     *
     * @param interceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        //  接口签名认证拦截器，该签名认证比较简单，实际项目中可以使用Json Web Token或其他更好的方式替代。
        //  开发环境忽略签名认证
        interceptorRegistry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                //  任务1：白名单无token 不阻止
//                log.info("进入mvc拦截器");
                //  Eolinker User-Token
                //  解决跨域问题  2020-1-8 增加多源访问
                //  任务1：解决跨域问题yfw_adminlog
                String[] whiteList = {"http://www.yf.com", "http://127.0.0.1", "http://www.fangdianwang.com", "http://www.yuefangwang.com"};
                String myOrigin = request.getHeader("origin");
                boolean domainIsValid = false;
                for (String ip : whiteList) {
                    if (myOrigin != null && myOrigin.equals(ip)) {
                        domainIsValid = true;
                        break;
                    }
                }
                // 任务2：设置请求头信息
//                    log.info("任务1：设置请求头信息");
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                httpServletRequest.getSession();
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setHeader("Access-Control-Allow-Origin", domainIsValid ? myOrigin : "null");
                httpResponse.setHeader("Access-Control-Allow-Methods", "*");
                httpResponse.setHeader("Access-Control-Max-Age", "3600");
                httpResponse.setHeader("Access-Control-Allow-Headers", "Origin,User-Token, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
                httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
                httpResponse.setHeader("Content-type", "application/json");
                httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
                //  首先从请求头中获取jwt串，与页面约定好存放jwt值的请求头属性名为User-Token
                //  登录获取jwt地址白名单，这些地址无需检查jwt有效性，直接放行。
                //  log.info("任务2,白名单直接放行");
                //  任务3：白名单直接放行

                    return super.preHandle(request, response, handler);  //直接放行。


            }
        });

    }
}
