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
     * Min & Max would be the count
     */
    POPULAR("popular"),
    /**
     * Min & Max would be Date
     */
    ACTIVITY("activity"),
    /**
     * Min & Max would be starting letter of the name
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
}
