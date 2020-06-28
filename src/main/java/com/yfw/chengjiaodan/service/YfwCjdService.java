package com.yfw.chengjiaodan.service;


import com.yfw.chengjiaodan.base.BaseResponse;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

public interface YfwCjdService {

    BaseResponse<YfwCjdEntity> addSubmit(@Valid YfwCjdEntity yfwCjdEntity);
}
