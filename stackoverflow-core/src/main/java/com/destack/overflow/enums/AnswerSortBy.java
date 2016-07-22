package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sort Answers By Latest Activity , Creation time, Number of votes
 * 
 * @author Deepak
 *
 */
public enum AnswerSortBy {

    /**
     * min & max should be Date
     */
    ACTIVITY("activity"),
    /**
     * min & max should be Date
     */
    CREATION("creation"),
    /**
     * min & max should be the number of votes for answer
     */
    VOTES("votes");

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerSortBy.class);

    private String sortBy;

    private AnswerSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return sortBy;
    }

    public static boolean isContains(AnswerSortBy answerSortBy) {
        if (answerSortBy != null) {
            for (AnswerSortBy sort : AnswerSortBy.class.getEnumConstants()) {
                if (sort.equals(answerSortBy)) {
                    LOGGER.info("AnswerSortBy value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean isValid(AnswerSortBy answerSortBy) {
        if (answerSortBy != null) {
            return isContains(answerSortBy);
        } else {
            LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }

}
