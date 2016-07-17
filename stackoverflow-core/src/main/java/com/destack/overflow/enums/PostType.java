package com.destack.overflow.enums;


public enum PostType {
    ANSWER("answer"),
    QUESTION("question");

    private String name;

    private PostType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
