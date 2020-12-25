package com.gen.com.Insurance_portal.common.enums;

public enum ProductProviderStatus {
    PENDING("chờ duyệt"),
    APPROVED("đã duyệt"),
    DENIED("từ chối duyệt");

    private String value;

    ProductProviderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
