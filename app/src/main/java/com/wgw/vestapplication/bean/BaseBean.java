package com.wgw.vestapplication.bean;

import java.io.Serializable;

public class BaseBean<T> implements Serializable {
    private static int SUCCESS_CODE = 200;
    private int code;
    private String message;
    private T data;
    public boolean isSuccess(){
        return getCode() == SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
