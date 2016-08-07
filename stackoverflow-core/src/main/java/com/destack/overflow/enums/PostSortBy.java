package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sort Posts By Latest Activity , Creation time, Number of votes
 * 
 * @author Deepak
 *
 */
public enum PostSortBy {
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

    private static final Logger LOGGER = LoggerFactory.getLogger(PostSortBy.class);

    private String sortBy;

    private PostSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return sortBy;
    }

    public static boolean isContains(PostSortBy postSortBy) {
        if (postSortBy != null) {
            for (PostSortBy sort : PostSortBy.class.getEnumConstants()) {
                if (sort.equals(postSortBy)) {
                    LOGGER.info("PostSortBy value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("PostSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean isValid(PostSortBy postSortBy) {
        if (postSortBy != null) {
            return isContains(postSortBy);
        } else {
            LOGGER.warn("PostSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }
}
