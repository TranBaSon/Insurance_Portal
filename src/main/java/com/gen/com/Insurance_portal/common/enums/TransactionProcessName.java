package com.gen.com.Insurance_portal.common.enums;

public enum TransactionProcessName {
    BuyNew("Mua mới"),
    Extend("Gia Hạn"),
    Cancel("Hủy"),
    PaymentSuccess("Thanh toán thành công");

    private String value;

    TransactionProcessName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
