package com.destack.overflow.enums;

/**
 * {@link TagSortBy} for {@link TagRetriever}'s SYNONYMS. Tag Sort Order<br/>
 * <br/>
 * if {@link #CREATION} then min & max should be Date <br/>
 * if {@link #APPLIED} then min & max should be count <br/>
 * if {@link #ACTIVITY} then min & max should be Date <br/>
 * 
 * @author Deepak
 *
 */
public enum TagSortBySynonyms {
    /**
     * min & max should be Date
     */
    CREATION("creation"),
    /**
     * min & max should be count
     */
    APPLIED("applied"),
    /**
     * min & max should be Date
     */
    ACTIVITY("activity");

    private String name;

    private TagSortBySynonyms(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean contains(TagSortBySynonyms tagSortBySynonyms) {
        if (tagSortBySynonyms != null) {
            for (TagSortBySynonyms sort : TagSortBySynonyms.class.getEnumConstants()) {
                if (sort.equals(tagSortBySynonyms)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validate(TagSortBySynonyms tagSortBySynonyms) {
        if (tagSortBySynonyms != null) {
            return contains(tagSortBySynonyms);
        } else {
            return false;
        }
    }
}
