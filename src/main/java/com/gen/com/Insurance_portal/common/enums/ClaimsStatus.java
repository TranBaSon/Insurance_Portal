package com.gen.com.Insurance_portal.common.enums;

public enum ClaimsStatus {
    Waiting("chờ"),
    Done("hoàn thành");

    private String value;

    ClaimsStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
