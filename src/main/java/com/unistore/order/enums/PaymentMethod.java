package com.unistore.order.enums;

public enum PaymentMethod {
    DEBIT_CARD("DEBIT_CARD");

    private String method;

    private PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
