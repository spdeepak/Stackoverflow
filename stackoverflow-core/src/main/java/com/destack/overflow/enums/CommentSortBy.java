package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentSortBy.class);

    public static boolean isContains(CommentSortBy answerSortBy) {
        if (answerSortBy != null) {
            for (CommentSortBy sort : CommentSortBy.class.getEnumConstants()) {
                if (sort.equals(answerSortBy)) {
                    LOGGER.info("AnswerSortBy value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean isValid(CommentSortBy answerSortBy) {
        if (answerSortBy != null) {
            return isContains(answerSortBy);
        } else {
            LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }
}
