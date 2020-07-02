package com.yfw.chengjiaodan.service;


import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface YfwCjdService {

    BaseResponse<YfwCjdEntity> addSubmit(@Valid YfwCjdEntity yfwCjdEntity);

    List<Map<String,Object>> findYfwCjdList(Integer page,Integer size,String sort);
}
