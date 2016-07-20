package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(BadgeSortBy.class);

    public static boolean isContains(BadgeSortBy badegSortBy) {
        if (badegSortBy != null) {
            for (BadgeSortBy sort : BadgeSortBy.class.getEnumConstants()) {
                if (sort.equals(badegSortBy)) {
                    LOGGER.info("AnswerSortBy value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean isValid(BadgeSortBy badgeSortBy) {
        if (badgeSortBy != null) {
            return isContains(badgeSortBy);
        } else {
            LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }
}
