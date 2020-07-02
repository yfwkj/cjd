package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;

import java.util.Objects;

/**
 * @ClassName: YfwCjdYjblEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 10:51
 * @Version: 1.0
 **/
@Data
public class YfwCjdYjblEntity {
    //主键
    private int id;

    //申请单编号
    private String cjdNo;

    //纳入业绩
    private Integer isYeji;

    //分销分类
    private String mainType;

    //类别
    private String yjType;

    //部门
    private String deptId;

    //姓名
    private String staffId;

    //佣金比例
    private String yjRate;

    //佣金金额
    private String yjAmount;

    //分成比例
    private String fcRate;

    //所得佣金
    private String getAmount;

    //业绩金额
    private String yejiAmount;

    //税率
    private String texRate;

    //扣税
    private String texAmount;

    //工资未结
    private String isSalaryok;

    //网销
    private String isNetsell;

    private String createdBy;

    private String createdTime;

    private String del;


}
