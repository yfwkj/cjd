package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;

/**
 * @ClassName: StaffVoEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 17:20
 * @Version: 1.0
 **/
@Data
public class StaffVoEntity extends YfwStaffEntity {
    private String positionName;
    private String deptName;

}
