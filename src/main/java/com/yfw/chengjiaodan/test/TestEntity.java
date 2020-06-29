package com.yfw.chengjiaodan.test;

import lombok.Data;

import javax.validation.constraints.DecimalMax;

/**
 * @ClassName: TestEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 9:02
 * @Version: 1.0
 **/
@Data
public class TestEntity {

    @DecimalMax(value = "999",message = "超过最大值")
    private int number;
}
