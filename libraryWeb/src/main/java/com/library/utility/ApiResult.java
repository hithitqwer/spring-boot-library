package com.library.utility;

public class ApiResult<T> {

    private int code;

    private String message;

    private T data;

    private boolean success;

    public ApiResult(){
        this.success = true;
    }

    public ApiResult(T data) {
        this.success = true;
        this.data = data;
    }

    public ApiResult(boolean success,T data,String message) {
        this.message = message;
        this.data = data;
        this.success = success;
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
        data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
