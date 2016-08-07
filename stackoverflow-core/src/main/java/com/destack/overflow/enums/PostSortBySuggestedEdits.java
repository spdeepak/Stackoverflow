package com.destack.overflow.enums;

/**
 * Returns suggsted edits on the posts identified in ids. <br/>
 * <br/>
 * <b>creation </b>– <i>creation_date</i> <br/>
 * <b>approval </b>– <i>approval_date</i> <br/>
 * <b>rejection </b> – <i>rejection_date</i> <br/>
 * <br/>
 * <b>creation </b> is the default sort.
 * 
 * @author Deepak
 *
 */
public enum PostSortBySuggestedEdits {
    /**
     * 
     */
    CREATION("creation"),
    /**
     * 
     */
    APPROVAL("approval"),
    /**
     * 
     */
    REJECTION("rejection");

    private String name;

    private PostSortBySuggestedEdits(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean isContains(PostSortBySuggestedEdits postSortBySuggestedEdits) {
        if (postSortBySuggestedEdits != null) {
            for (PostSortBySuggestedEdits sort : PostSortBySuggestedEdits.class.getEnumConstants()) {
                if (sort.equals(postSortBySuggestedEdits)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(PostSortBySuggestedEdits postSortBySuggestedEdits) {
        if (postSortBySuggestedEdits != null) {
            return isContains(postSortBySuggestedEdits);
        } else {
            return false;
        }
    }
}
