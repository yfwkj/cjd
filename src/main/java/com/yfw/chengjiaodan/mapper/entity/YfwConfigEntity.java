package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
//    private int id;
//    private String name;
//    private String groupName;
//    private String title;
//    private String tip;
//    private String type;
    private String value;
//    private String content;
//    private String rule;
//    private Integer extend = 0;
//    private String createdBy;
//
//    @NotBlank(message = "创建时间日期不能为空")
//    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "创建时间日期格式不正确:YYYY-MM-DD")
//    private String createdTime;
//
//    private String updateBy;
//
//    @NotBlank(message = "更新时间日期不能为空")
//    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "更新时间日期格式不正确:YYYY-MM-DD")
//    private String updateTime;
//
//    private Integer del = 0;


}
