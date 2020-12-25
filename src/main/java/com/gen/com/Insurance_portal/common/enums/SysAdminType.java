package com.gen.com.Insurance_portal.common.enums;

public enum SysAdminType {
    ADMIN("Admin"),
    ProductProvider("ProductProvider");

    private String value;

    SysAdminType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
