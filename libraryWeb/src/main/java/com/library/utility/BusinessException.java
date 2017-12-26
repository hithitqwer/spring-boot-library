package com.library.utility;

public class BusinessException extends RuntimeException {

    private int code;

    private String message;

    public BusinessException(String message) {
        this.code = 200;
        this.message = message;
    }

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
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
}
