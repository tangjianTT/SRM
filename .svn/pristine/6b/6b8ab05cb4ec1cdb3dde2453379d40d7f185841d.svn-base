package com.neusoft.srm.util;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

/**
 * @Author：Jingyang.Wu
 * @Date：2018/12/2.
 * @Description:响应数据包装类
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//JsonSerialize注解  保证序列化json的时候，如果是null的对象，key也会消失
public class ServerResponse<T> implements Serializable {

    private int resultCode;
    private String resultMsg;
    private T data;

    private ServerResponse(int resultCode) {
        this.resultCode = resultCode;
    }

    private ServerResponse(int resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    private ServerResponse(int resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    private ServerResponse(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @JsonIgnore
    //使之在返回的数据模型中，不显示key。不在序列化结果当中
    public boolean isSuccess() {
        return this.resultCode == 200;
    }

    public int getresultCode() {
        return resultCode;
    }

    public T getData() {
        return data;
    }

    public String getresultMsg() {
        return resultMsg;
    }


    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS);
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String resultMsg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS, resultMsg);
    }

    public static <T> ServerResponse<T> createBySuccesss(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS, data);
    }

    public static <T> ServerResponse<T> createBySuccess(String resultMsg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS, resultMsg, data);
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERORR, errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}