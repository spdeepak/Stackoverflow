package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For Ranks, bronze is greater than silver which is greater than gold
 * 
 * @author Deepak
 *
 */
public enum MaxMin {
    /**
     * {@link #GOLD} has less value than {@link #SILVER} & {@link #BRONZE}
     */
    GOLD("gold"),
    /**
     * {@link #SILVER} is greater than {@link #GOLD}. But {@link #BRONZE} is greater than
     * {@link #SILVER}
     */
    SILVER("silver"),
    /**
     * {@link #BRONZE} is greater than {@link #SILVER} which is greater than {@link #GOLD}
     */
    BRONZE("bronze");

    private String name;

    private MaxMin(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MaxMin.class);

    public static boolean contains(MaxMin maxmin) {
        if (maxmin != null) {
            for (MaxMin sort : MaxMin.class.getEnumConstants()) {
                if (sort.equals(maxmin)) {
                    LOGGER.info("AnswerSortBy value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean validate(MaxMin maxmin) {
        if (maxmin != null) {
            return contains(maxmin);
        } else {
            LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }
}
