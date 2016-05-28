package com.destack.overflow.enums;

public enum MaxMin {
    GOLD("gold"),
    SILVER("silver"),
    BRONZE("bronze");

    private String name;

    private MaxMin(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
