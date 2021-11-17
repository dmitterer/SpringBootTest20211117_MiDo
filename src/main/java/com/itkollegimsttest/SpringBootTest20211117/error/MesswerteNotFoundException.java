package com.itkollegimsttest.SpringBootTest20211117.error;

public class MesswerteNotFoundException extends Exception{
    public MesswerteNotFoundException() {
        super();
    }

    public MesswerteNotFoundException(String message) {
        super(message);
    }

    public MesswerteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MesswerteNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MesswerteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

