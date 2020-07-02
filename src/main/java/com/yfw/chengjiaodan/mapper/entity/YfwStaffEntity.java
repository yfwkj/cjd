package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: YfwStaffEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/2 17:23
 * @Version: 1.0
 **/
@Data
public class YfwStaffEntity {
    private int id;
    private String name;
    private String phone;
    private String tel;
    private String password;
    private String noid;
    private String states;
    private String selfon;
    private String staffType;
    private Integer leaderid;
    private Integer deptid;
    private String companybelone;
    private Integer hideList;
    private Integer hasDeptid;
    private Integer apprDeptid;
    private Integer positionId;
    private Integer salaryDeptid;
    private Integer salaryYear;
    private Integer effBonus;
    private Integer salary;
    private Integer effBu;
    private Integer positionBu;
    private Integer otherFeiyong;
    private Integer houseBu;
    private Integer jingtie;
    private Integer educationChildren;
    private Integer education;
    private Integer hospital;
    private Integer houseDaikun;
    private Integer houseSalary;
    private Integer elderly;
    private Integer fundStaff;
    private Integer socialStaff;
    private Integer fundCom;
    private Integer socialCom;
    private Integer parentStaff;
    private Integer parentCom;
    private Integer carMonth;
    private Integer carDay;
    private String bankName;
    private String bankId;
    private Integer banciId;
    private Integer workZone;
    private String beizhu;
    private Integer locationId;
    private String imgurl;
    private String createdBy;
    private Timestamp createdTime;
    private String updateBy;
    private Timestamp updateTime;


}
