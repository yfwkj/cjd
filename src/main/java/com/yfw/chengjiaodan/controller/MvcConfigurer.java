package com.yfw.chengjiaodan.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.chtwm.component.constant.SecretConstant;
import com.chtwm.component.secret.AESSecretUtil;
import com.chtwm.component.util.JwtHelper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
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
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                httpServletRequest.getSession();
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                String jwt = request.getHeader("User-Token");
                String myRequestURI = request.getRequestURI();
                boolean myRequestURIisValid = false;
                String[] whiteApiList = {"/cjd/cjdAttach/upload"};
                for (String url : whiteApiList) {
                    if (myRequestURI != null && myRequestURI.equals(url)) {
                        myRequestURIisValid = true;
                        break;
                    }
                }
                String myOrigin = request.getHeader("origin");
                boolean domainIsValid = false;
                String[] whiteList = {"http://www.yf.com", "http://127.0.0.1", "http://www.fangdianwang.com", "http://www.yuefangwang.com"};

                for (String ip : whiteList) {
                    if (myOrigin != null && myOrigin.equals(ip)) {
                        domainIsValid = true;
                        break;
                    }
                }
                httpResponse.setHeader("Access-Control-Allow-Origin", domainIsValid ? myOrigin : "null");
                httpResponse.setHeader("Access-Control-Allow-Methods", "*");
                httpResponse.setHeader("Access-Control-Max-Age", "3600");
                httpResponse.setHeader("Access-Control-Allow-Headers", "Origin,User-Token, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
                httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
                httpResponse.setHeader("Content-type", "application/json");
                httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");


                if (myRequestURIisValid) {
                    return super.preHandle(request, response, handler);  //直接放行。
                }

                if (jwt == null) {
                    return false;
                }

                if (jwt.equals("Eolinker User-Token")) {
                    return super.preHandle(request, response, handler);
                }
                String method = request.getMethod();
                if ("OPTIONS".equals(request.getMethod().toString())) {
                    return super.preHandle(request, response, handler);
                }
                if (StringUtils.isNotBlank(jwt)) {
                    String retJson = JwtHelper.validateLogin(jwt);
                    if (StringUtils.isNotBlank(retJson)) {
                        JSONObject jsonObject = JSONObject.parseObject(retJson);
                        String userAgent = httpServletRequest.getHeader("User-Agent");
                        if (userAgent.equals(jsonObject.getString("userAgent"))) {
                            Claims claims = JwtHelper.parseJWT(jwt);
                            String token = JwtHelper.generateJWT((String) claims.get("userId"), (String) claims.get("userName"), userAgent);
                            httpResponse.setHeader("User-Token", jsonObject.getString("freshToken"));
                            httpResponse.setHeader("Access-Control-Expose-Headers", "User-Token");
                            httpResponse.setHeader("Access-Control-Allow-Headers", "Origin,User-Token, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie, token");
//                            获取ID
                            int userId = (Integer.parseInt(AESSecretUtil.decryptToStr((String) claims.get("userId"), SecretConstant.DATAKEY)));

                            return true;
                        }
                    }
                }
                return super.preHandle(request, response, handler);
            }
    } );
}
}
