package com.db.user.exception;

public enum ErrorCode {
    USER_EXITAED(1001,"user exited"),
    USER_NOTFOUND(1002,"user not found"),
    UNCATEGORIZED_EXCEPTION(9999,"uncategorized error"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
