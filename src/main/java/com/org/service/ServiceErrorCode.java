package com.org.service;

public enum ServiceErrorCode {
    NOT_FOUND_ERROR(34,"The resource you requested could not be found."),
    INVALID_API_KEY(7,"Invalid API key: You must be granted a valid key.");

    private final Integer errCode;
    private final String errMsg;

    private ServiceErrorCode(Integer errCode,String msg) {
        this.errCode = errCode;
        this.errMsg = msg;
    }

    public Integer getServiceErrorCode() {
        return this.errCode;
    }

    public String getServiceErrorMessage() {
        return this.errMsg;
    }


}
