package com.base;

import lombok.Data;

/**
 *
 * Description: 返回工具类 <br/>
 * date: 下午5:22:51 <br/>
 *
 * @author chenYZ
 * @version @param <T>
 */
@Data
public class BaseResponse<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 返回
     */
    private T data;
    // 分页

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
