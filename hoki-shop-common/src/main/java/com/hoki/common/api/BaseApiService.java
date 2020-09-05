package com.hoki.common.api;

import com.hoki.constant.BaseApiConstant;

import static com.hoki.constant.BaseApiConstant.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:BaseApiService
 * Package:com.hoki.common.api
 * Description:通用baseapi
 *
 * @author :Hoki_Lin
 * @date :2020/9/1 16:02
 */
public class BaseApiService {

    /**
     * 返回错误
     *
     * @param msg
     * @return
     */
    public Map<String, Object> setResultError(String msg) {
        return setResult(HTTP_RES_CODE_500, msg, null);
    }

    /**
     * 返回成功
     *
     * @return
     */
    public Map<String, Object> setResultSuccess() {
        return setResult(HTTP_RES_CODE_200, HTTP_RES_CODE_200_VALUE, null);
    }

    public Map<String, Object> setResultSuccessData(Object data) {
        return setResult(HTTP_RES_CODE_200, HTTP_RES_CODE_200_VALUE, data);
    }

    public Map<String, Object> setResultSuccess(String msg) {
        return setResult(HTTP_RES_CODE_200, msg, null);
    }

    /**
     * 参数错误
     *
     * @param msg
     * @return
     */
    public Map<String, Object> setResultParameterError(String msg) {
        return setResult(BaseApiConstant.HTTP_RES_CODE_400, msg, null);
    }

    /**
     * 自定义返回json
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public Map<String, Object> setResult(Integer code, String msg, Object data) {
        Map<String, Object> result = new HashMap<>(3);
        result.put(HTTP_RES_CODE_NAME, code);
        result.put(HTTP_RES_CODE_MSG, msg);
        if (data != null) {
            result.put(HTTP_RES_CODE_DATA, data);
        }
        return result;
    }
}
