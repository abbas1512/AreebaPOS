package com.areeba.POS.common.CustomResponse;

public class SuccessResponse {

    private String status;
    private Object data;

    public SuccessResponse() {
    }

    public String getStatus() {
        return this.status;
    }

    public Object getData() {
        return this.data;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SuccessResponse)) {
            return false;
        } else {
            SuccessResponse other = (SuccessResponse)o;
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
        return other instanceof SuccessResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getStatus();
        return "SuccessResponse(status=" + var10000 + ", data=" + this.getData() + ")";
    }

}
