package com.mapper.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName: YfwConfigEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/28 9:38
 * @Version: 1.0
 **/
@Data
public class YfwConfigEntity {
    private int id;
    private String cjNo;
    private String name;
    private String groupName;
    private String title;
    private String tip;
    private String type;
    private String value;
    private String content;
    private String rule;
    private Integer extend;
    private String createdBy;
    private Timestamp createdTime;
    private String updateBy;
    private Timestamp updateTime;
    private Integer del;


}
