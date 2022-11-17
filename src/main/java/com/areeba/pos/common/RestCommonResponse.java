package com.areeba.pos.common;

public class RestCommonResponse {
    private Boolean status;
    private Object data;
    private Integer responseCode;
    private String title;
    private String message;
    private String developerMessage;

    public RestCommonResponse(Boolean status) {
        this.status = status;
        this.data = new Object();
        if (status) {
            this.responseCode = 1;
            this.title = "Success";
            this.message = "action done";
            this.developerMessage = "";
        } else {
            this.responseCode = 400;
            this.title = "Failure";
            this.message = "action not completed";
            this.developerMessage = "";
        }

    }

    public RestCommonResponse(Boolean status, Object data) {
        this.status = status;
        this.data = data;
        if (status) {
            this.responseCode = 1;
            this.title = "Success";
            this.message = "action done";
            this.developerMessage = "";
        } else {
            this.responseCode = 400;
            this.title = "Failure";
            this.message = "action not completed";
            this.developerMessage = "";
        }

    }

    public RestCommonResponse(Boolean status, Object data, Integer responseCode, String title, String message) {
        this.status = status;
        this.data = data == null ? new Object() : data;
        this.responseCode = responseCode;
        this.title = title;
        this.message = message;
        this.developerMessage = "";
    }

    public RestCommonResponse(Boolean status, Object data, Integer responseCode, String title, String message, String developerMessage) {
        this.status = status;
        this.data = data == null ? new Object() : data;
        this.responseCode = responseCode;
        this.title = title;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public RestCommonResponse(Boolean status, String data, Integer responseCode, String title, String message) {
        this.status = status;
        this.data = data == null ? new Object() : data;
        this.responseCode = responseCode;
        this.title = title;
        this.message = message;
        this.developerMessage = "";
    }

    public Boolean getStatus() {
        return this.status;
    }

    public Object getData() {
        return this.data;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public void setStatus(final Boolean status) {
        this.status = status;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public void setResponseCode(final Integer responseCode) {
        this.responseCode = responseCode;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setDeveloperMessage(final String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RestCommonResponse)) {
            return false;
        } else {
            RestCommonResponse other = (RestCommonResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$responseCode = this.getResponseCode();
                Object other$responseCode = other.getResponseCode();
                if (this$responseCode == null) {
                    if (other$responseCode != null) {
                        return false;
                    }
                } else if (!this$responseCode.equals(other$responseCode)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                label62: {
                    Object this$title = this.getTitle();
                    Object other$title = other.getTitle();
                    if (this$title == null) {
                        if (other$title == null) {
                            break label62;
                        }
                    } else if (this$title.equals(other$title)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label55;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label55;
                    }

                    return false;
                }

                Object this$developerMessage = this.getDeveloperMessage();
                Object other$developerMessage = other.getDeveloperMessage();
                if (this$developerMessage == null) {
                    if (other$developerMessage != null) {
                        return false;
                    }
                } else if (!this$developerMessage.equals(other$developerMessage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RestCommonResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $responseCode = this.getResponseCode();
        result = result * 59 + ($responseCode == null ? 43 : $responseCode.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $developerMessage = this.getDeveloperMessage();
        result = result * 59 + ($developerMessage == null ? 43 : $developerMessage.hashCode());
        return result;
    }

    public String toString() {
        Boolean var10000 = this.getStatus();
        return "RestCommonResponse(status=" + var10000 + ", data=" + this.getData() + ", responseCode=" + this.getResponseCode() + ", title=" + this.getTitle() + ", message=" + this.getMessage() + ", developerMessage=" + this.getDeveloperMessage() + ")";
    }
}
