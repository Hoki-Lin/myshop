package com.hoki.constant;

/**
 * ClassName:BaseApiConstant
 * Package:com.hoki.constant
 * Description:采用常量接口模式(参考: https://www.cnblogs.com/jingpeipei/p/5578302.html)
 *
 * @author :Hoki_Lin
 * @date :2020/9/1 16:16
 */
public interface BaseApiConstant {
    /**
     * 响应code
     */
    String  HTTP_RES_CODE_NAME      = "code";
    /**
     * 响应msg
     */
    String  HTTP_RES_CODE_MSG       = "msg";
    /**
     * 响应data
     */
    String  HTTP_RES_CODE_DATA      = "data";
    /**
     * 响应请求成功
     */
    String  HTTP_RES_CODE_200_VALUE = "success";
    /**
     * 系统错误
     */
    String  HTTP_RES_CODE_500_VALUE = "fail";
    /**
     * 响应请求成功code
     */
    Integer HTTP_RES_CODE_200       = 200;
    /**
     * 系统错误
     */
    Integer HTTP_RES_CODE_500       = 500;
    /**
     * 参数错误
     */
    Integer HTTP_RES_CODE_400       = 400;
}
