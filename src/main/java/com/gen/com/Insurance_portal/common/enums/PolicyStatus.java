package com.gen.com.Insurance_portal.common.enums;

public enum PolicyStatus {

    Active("Hoạt động"),
    Expired("Hết hạn"),
    Cancelled("Đã huỷ"),
    Inactive("Chưa kích hoạt");

    private String value;

    PolicyStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
