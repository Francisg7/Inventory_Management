package com.eurekadevops.sabre.web.errors;

public class SettingsNotFoundException extends RuntimeException {

    public SettingsNotFoundException() {
    }

    public SettingsNotFoundException(String message) {
        super(message);
    }

    public SettingsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingsNotFoundException(Throwable cause) {
        super(cause);
    }

    public SettingsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
