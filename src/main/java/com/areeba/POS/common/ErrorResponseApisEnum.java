package com.areeba.POS.common;

import com.areeba.POS.common.LocalHelpers.LocaleMessageHelper;

public enum ErrorResponseApisEnum {

    NotVerifiedUser(40001, "Not Verified", "Kindly verify phone number then login again", ""),
    OtpVerificationFailed(40002, "Verification Failed", "This Verification Code is invalid.", ""),
    OtpResendFailed(40003, "Resend Failed", "failed to send otp for user.", ""),
    AccountAlreadyVerified(40004, "Already Verified", "This number is already verified.", ""),
    WrongOldPassword(40005, "Wrong Password", "Wrong old password.", ""),
    InvalidCredentials(40006, "Invalid credentials", "Invalid credentials, wrong phone number or password", ""),
    RefreshTokenFailed(40007, "Refresh Failed", "Invalid refresh token provided", ""),
    InvalidPhoneNumber(40008, "Invalid Number", "Invalid phone number format.", ""),
    DoesntExist(40009, "User Not Found", "User not found", ""),
    AlreadyRegistered(40013, "Already Registered", "Account already registered.", ""),
    InvalidUser(400014, "Refresh Failed", "Invalid user, not able to refresh token", ""),
    ItemNotFound(400015, "Not Found", "Item not found", "");

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
