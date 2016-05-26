package com.destack.overflow.enums;


public enum BadgeSortBy {
    RANK("rank"),
    NAME("name"),
    TYPE("type");

    private String name;

    private BadgeSortBy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
