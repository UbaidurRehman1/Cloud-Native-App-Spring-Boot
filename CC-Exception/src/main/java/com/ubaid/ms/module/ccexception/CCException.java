package com.ubaid.ms.module.ccexception;

public class CCException  extends RuntimeException {
    public CCException() {
    }

    public CCException(Throwable cause) {
        super(cause);
    }

    public CCException(String message, Throwable cause) {
        super(message, cause);
    }

    public CCException(String message) { super(message);}
}
