package com.destack.overflow.enums;

/**
 * Sort Answers By Latest Activity , Creation time, Number of votes
 * 
 * @author Deepak
 *
 */
public enum AnswerSortBy {
    ACTIVITY("activity"),
    CREATION("creation"),
    VOTES("votes");

    private String sortBy;

    private AnswerSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return sortBy;
    }

}