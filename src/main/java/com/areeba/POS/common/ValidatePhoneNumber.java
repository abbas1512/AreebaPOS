package com.areeba.POS.common;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class ValidatePhoneNumber {

    String userId;
    String phoneNumberWithCode;
    String phoneNumber;
    String phoneCode;
    String countryCode;
    Boolean isValid;

    public ValidatePhoneNumber(String phoneCode, String phone_number) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        String defaultRegion = phoneUtil.getRegionCodeForCountryCode(Integer.parseInt(phoneCode));

        try {
            if (null != phone_number && !phone_number.isEmpty()) {
                Phonenumber.PhoneNumber proto = phoneUtil.parse(phone_number, defaultRegion);
                this.isValid = phoneUtil.isValidNumber(proto);
                if (this.isValid) {
                    this.phoneNumber = Long.toString(proto.getNationalNumber());
                    this.phoneCode = Integer.toString(proto.getCountryCode());
                    this.countryCode = this.getCountryCode(this.phoneCode);
                    this.phoneNumberWithCode = this.phoneCode + this.phoneNumber;
                    this.userId = new String(this.phoneNumberWithCode);
                }
            } else {
                this.isValid = false;
            }
        } catch (NumberParseException var6) {
            this.isValid = false;
        }

    }

    public String getCountryCode(String phoneCode) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        return phoneUtil.getRegionCodeForCountryCode(Integer.parseInt(phoneCode));
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPhoneNumberWithCode() {
        return this.phoneNumberWithCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPhoneCode() {
        return this.phoneCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Boolean getIsValid() {
        return this.isValid;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setPhoneNumberWithCode(final String phoneNumberWithCode) {
        this.phoneNumberWithCode = phoneNumberWithCode;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneCode(final String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public void setIsValid(final Boolean isValid) {
        this.isValid = isValid;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ValidatePhoneNumber)) {
            return false;
        } else {
            ValidatePhoneNumber other = (ValidatePhoneNumber)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$isValid = this.getIsValid();
                Object other$isValid = other.getIsValid();
                if (this$isValid == null) {
                    if (other$isValid != null) {
                        return false;
                    }
                } else if (!this$isValid.equals(other$isValid)) {
                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$phoneNumberWithCode = this.getPhoneNumberWithCode();
                Object other$phoneNumberWithCode = other.getPhoneNumberWithCode();
                if (this$phoneNumberWithCode == null) {
                    if (other$phoneNumberWithCode != null) {
                        return false;
                    }
                } else if (!this$phoneNumberWithCode.equals(other$phoneNumberWithCode)) {
                    return false;
                }

                label62: {
                    Object this$phoneNumber = this.getPhoneNumber();
                    Object other$phoneNumber = other.getPhoneNumber();
                    if (this$phoneNumber == null) {
                        if (other$phoneNumber == null) {
                            break label62;
                        }
                    } else if (this$phoneNumber.equals(other$phoneNumber)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$phoneCode = this.getPhoneCode();
                    Object other$phoneCode = other.getPhoneCode();
                    if (this$phoneCode == null) {
                        if (other$phoneCode == null) {
                            break label55;
                        }
                    } else if (this$phoneCode.equals(other$phoneCode)) {
                        break label55;
                    }

                    return false;
                }

                Object this$countryCode = this.getCountryCode();
                Object other$countryCode = other.getCountryCode();
                if (this$countryCode == null) {
                    if (other$countryCode != null) {
                        return false;
                    }
                } else if (!this$countryCode.equals(other$countryCode)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ValidatePhoneNumber;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $isValid = this.getIsValid();
        result = result * 59 + ($isValid == null ? 43 : $isValid.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $phoneNumberWithCode = this.getPhoneNumberWithCode();
        result = result * 59 + ($phoneNumberWithCode == null ? 43 : $phoneNumberWithCode.hashCode());
        Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        Object $phoneCode = this.getPhoneCode();
        result = result * 59 + ($phoneCode == null ? 43 : $phoneCode.hashCode());
        Object $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getUserId();
        return "ValidatePhoneNumber(userId=" + var10000 + ", phoneNumberWithCode=" + this.getPhoneNumberWithCode() + ", phoneNumber=" + this.getPhoneNumber() + ", phoneCode=" + this.getPhoneCode() + ", countryCode=" + this.getCountryCode() + ", isValid=" + this.getIsValid() + ")";
    }

}
