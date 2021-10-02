package com.unstore.order;

public enum Status {
    // Your order is {status}.
    // [Pending] -> [Received] -> [Approved] -> (Being produced) -> [Being packed] -> [Under transport] -> [Delivered]
    PENDING("PENDING"),
    RECEIVED("RECEIVED"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED"),
    BEING_PRODUCED("BEING_PRODUCED"),
    BEING_PACKED("BEING_PACKED"),
    UNDER_TRANSPORT("UNDER_TRANSPORT"),
    DELIVERED("DELIVERED");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
