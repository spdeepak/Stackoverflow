package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deepak
 *
 */
public enum PostSortBy2 {
    /**
     * min & max should be Date
     */
    CREATION("creation"),
    /**
     * min & max should be the number of votes for answer
     */
    VOTES("votes");

    private static final Logger LOGGER = LoggerFactory.getLogger(PostSortBy2.class);

    private String sortBy;

    private PostSortBy2(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return sortBy;
    }

    public static boolean isContains(PostSortBy2 postSortBy) {
        if (postSortBy != null) {
            for (PostSortBy2 sort : PostSortBy2.class.getEnumConstants()) {
                if (sort.equals(postSortBy)) {
                    LOGGER.info("PostSortBy2 value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("PostSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean isValid(PostSortBy2 postSortBy) {
        if (postSortBy != null) {
            return isContains(postSortBy);
        } else {
            LOGGER.warn("PostSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }
}
