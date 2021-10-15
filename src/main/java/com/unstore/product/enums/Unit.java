package com.unstore.product.enums;

public enum Unit {
    EACH("EACH");

    private String unit;

    private Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
