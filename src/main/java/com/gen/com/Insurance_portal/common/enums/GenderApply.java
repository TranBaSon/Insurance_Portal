package com.gen.com.Insurance_portal.common.enums;

public enum GenderApply {
    ALL("tất cả"),
    Male("nam"),
    FEMALE("nữ");

    private String value;

    GenderApply(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
