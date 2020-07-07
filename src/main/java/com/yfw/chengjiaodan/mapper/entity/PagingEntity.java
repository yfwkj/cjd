package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;

/**
 * @ClassName: PagingEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/7/1 11:55
 * @Version: 1.0
 **/
@Data
public class PagingEntity {
    private Integer page;
    private Integer size;
    private String sort;
}
