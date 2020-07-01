//package com.yfw.chengjiaodan.utils;
//
//import com.alibaba.fastjson.JSONObject;
//import com.github.pagehelper.PageInfo;
//import com.yfw.chengjiaodan.mapper.entity.PagingEntity;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @ClassName: PagingUtil
// * @Description: TODO
// * @Author: Chenyz
// * @Date: 2020/7/1 11:49
// * @Version: 1.0
// **/
//public class PagingUtil {
//    private static String DEFAULT_PAGE = "0";
//
//    private static String DEFAULT_SIZE = "5";
//
//    public static JSONObject paging(JSONObject values,List<Map<String, Object>> list){
//        PagingEntity defaultValue = getDefaultValue(values);
//        List<Map<String, Object>> listMap =
//                yfwCjdAttachService.findYfwCjdAttach(page, size, sort);
//        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(listMap);
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("Pages", defaultValue.getPage());
//        jsonObject.put("Orders", "");
//        jsonObject.put("size", mapPageInfo.getSize());
//        jsonObject.put("Total", mapPageInfo.getTotal());
//        jsonObject.put("Current", 1);
//        jsonObject.put("Records", mapPageInfo.getList());
//        return jsonObject;
//    }
//
//    public static PagingEntity getDefaultValue(JSONObject values){
//        PagingEntity pagingEntity = new PagingEntity();
//        String page = values.get("page") + "";
//        if(!StringUtils.isEmpty(page)){
//            pagingEntity.setPage(Integer.parseInt(page));
//        }
//        page = DEFAULT_PAGE;
//        String size = values.get("size") + "";
//        if(!StringUtils.isEmpty(size)){
//            pagingEntity.setSize(Integer.parseInt(size));
//        }
//        size = DEFAULT_SIZE;
//        String sort = values.get("sort") + "";
//        if(!StringUtils.isEmpty(sort)){
//            pagingEntity.setSort(sort);
//        }
//        sort = null;
//        return pagingEntity;
//
//    }
//}
