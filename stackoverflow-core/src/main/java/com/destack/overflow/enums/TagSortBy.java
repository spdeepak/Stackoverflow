package com.destack.overflow.enums;

/**
 * Tag Sort Order<br/>
 * <br/>
 * if {@link #POPULAR} then min & max should be count <br/>
 * if {@link #ACTIVITY} then min & max should be Date <br/>
 * if {@link #NAME} then min & max should be Strting letter of the Tag Name required
 * 
 * @author Deepak
 *
 */
public enum TagSortBy {
    /**
     * Min & Max should be the count
     */
    POPULAR("popular"),
    /**
     * Min & Max should be Date
     */
    ACTIVITY("activity"),
    /**
     * Min & Max should be starting letter of the name
     */
    NAME("name");

    private String name;

    private TagSortBy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean contains(TagSortBy tagSortBy) {
        for (TagSortBy sort : TagSortBy.class.getEnumConstants()) {
            if (sort.equals(tagSortBy)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validate(TagSortBy tagSortBy) {
        if (tagSortBy != null) {
            return contains(tagSortBy);
        } else {
            return false;
        }
    }
}
