package com.yfw.chengjiaodan.service;


import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfwkj.jsb.mapper.entity.YfwCjd;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface YfwCjdService {

    BaseResponse<YfwCjd> addSubmit(@Valid YfwCjd yfwCjd);

    List<Map<String,Object>> findYfwCjdList(Integer page,Integer size,String sort);
}
