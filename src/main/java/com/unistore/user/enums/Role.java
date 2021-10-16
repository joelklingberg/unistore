package com.unistore.user.enums;

public enum Role {
    MANUFACTURER("MANUFACTURER"),
    CUSTOMER("CUSTOMER");

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
