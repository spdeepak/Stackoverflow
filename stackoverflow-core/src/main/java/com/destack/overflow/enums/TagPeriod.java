package com.destack.overflow.enums;

/**
 * Get answerers active in a single tag, of either all-time or the last 30 days
 * 
 * @author Deepak
 *
 */
public enum TagPeriod {
    /**
     * Answerers active in a single tag of all-time or the last 30 days
     */
    ALL_TIME("all_time"),
    /**
     * Answerers active in a single tag of the last 30 days
     */
    MONTH("month");

    private String name;

    private TagPeriod(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean isContains(TagPeriod tagPeriod) {
        if (tagPeriod != null) {
            for (TagPeriod period : TagPeriod.class.getEnumConstants()) {
                if (period.equals(tagPeriod)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(TagPeriod tagPeriod) {
        if (tagPeriod != null) {
            return isContains(tagPeriod);
        } else {
            return false;
        }
    }
}
