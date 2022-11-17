package com.areeba.pos.common;

import com.areeba.pos.common.LocalHelpers.LocaleMessageHelper;

public enum ErrorResponseApisEnum {

    DoesNotExist(40001, "User Not Found", "User not found", ""),
    AlreadyRegistered(40002, "Already Registered", "Account already registered.", ""),
    InvalidUser(40003, "Refresh Failed", "Invalid user, not able to refresh token", ""),
    ItemNotFound(40004, "Not Found", "Item not found", "");

    private final int errorCode;
    private final String title;
    private final String message;
    private final String developerMessage;

    private ErrorResponseApisEnum(final int errorCode, final String title, final String message, final String developerMessage) {
        this.errorCode = errorCode;
        this.title = title;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getTitle() {
        return LocaleMessageHelper.getMessageByName(this.title);
    }

    public String getMessage() {
        return LocaleMessageHelper.getMessageByName(this.message);
    }

    public String getDeveloperMessage() {
        return LocaleMessageHelper.getMessageByName(this.developerMessage);
    }

}
