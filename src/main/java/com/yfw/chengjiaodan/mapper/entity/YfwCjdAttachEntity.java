package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @ClassName: YfwCjdAttachEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/29 15:39
 * @Version: 1.0
 **/
@Data
public class YfwCjdAttachEntity {
    private int id;
    private String cjdNo;

    @Pattern(regexp = "^[0-9]*$", message = "fileType必须为整数")
    @Size(min = 0, max = 11, message = "fileType的值超过最大值范围")
    private String fileType;

    private String url;
    private String thumbnail;
    private String ico;
    private String createdBy;
    private String createdTime;
    private String del;

}

