package com.areeba.POS.common.CustomResponse;

import java.util.HashMap;

public class RestResponse {
    private Integer action;
    private String message = "";
    private String developerMessage = "";
    private Object data = new HashMap();

    public RestResponse(Integer action, String message, String developerMessage, Object data) {
        this.action = action;
        this.message = message;
        this.developerMessage = developerMessage;
        this.data = data;
    }

    public RestResponse() {
    }

    public Integer getAction() {
        return this.action;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public Object getData() {
        return this.data;
    }

    public void setAction(final Integer action) {
        this.action = action;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setDeveloperMessage(final String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RestResponse)) {
            return false;
        } else {
            RestResponse other = (RestResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$action = this.getAction();
                    Object other$action = other.getAction();
                    if (this$action == null) {
                        if (other$action == null) {
                            break label59;
                        }
                    } else if (this$action.equals(other$action)) {
                        break label59;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
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

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RestResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $action = this.getAction();
        result = result * 59 + ($action == null ? 43 : $action.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $developerMessage = this.getDeveloperMessage();
        result = result * 59 + ($developerMessage == null ? 43 : $developerMessage.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        Integer var10000 = this.getAction();
        return "RestResponse(action=" + var10000 + ", message=" + this.getMessage() + ", developerMessage=" + this.getDeveloperMessage() + ", data=" + this.getData() + ")";
    }
}
