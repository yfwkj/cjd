package com.base;

import com.base.BaseResponse;
import com.constants.Constants;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * Description: 返回状态码工具类 <br/>
 *
 * @author chenYZ
 * @param code
 * @param message
 * @return
 */
@Data
@Component
public class BaseApiService<T> {

    public BaseResponse<T> setResultError(Integer code, String message) {
        return setResult(code, message, null);
    }

    // 返回错误，可以传message
    public BaseResponse<T> setResultError(String message) {
        return setResult(Constants.HTTP_RES_CODE_500, message, null);
    }

    // 返回成功，可以传data值
    public BaseResponse<T> setResultSuccess(T data) {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
    }

    // 返回成功，沒有data值
    public BaseResponse<T> setResultSuccess() {
        return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
    }

    // 返回成功，沒有data值
    public BaseResponse<T> setResultSuccess(String message) {
        return setResult(Constants.HTTP_RES_CODE_200, message, null);
    }

    // 通用封装
    public BaseResponse<T> setResult(Integer code, String message, T data) {
        return new BaseResponse<T>(code, message, data);
    }

    // 调用数据库层判断
    public Boolean toDaoResult(int result) {
        return result > 0 ? true : false;
    }

    public Boolean isSuccess(BaseResponse<?> baseResp) {
        if (baseResp == null) {
            return false;
        }
        if (baseResp.getCode().equals(Constants.HTTP_RES_CODE_500)) {
            return false;
        }
        return true;
    }

}
