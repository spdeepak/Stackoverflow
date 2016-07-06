package com.destack.overflow.enums;


public enum CommentSortBy {
    CREATION("creation"),
    VOTES("votes");

    private String name;

    private CommentSortBy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
