package com.destack.overflow.enums;

public enum BadgeRetriever {
    /**
     * Get all badges on the site, in alphabetical order.
     */
    NORMAL,
    /**
     * Get the badges identified by ids.
     */
    ID,
    /**
     * Get all non-tagged-based badges in alphabetical order.
     */
    NAME,
    /**
     * Get badges recently awarded on the site.
     */
    RECIPIENT,
    /**
     * Get the recent recipients of the given badges.
     */
    ID_RECIPIENT,
    /**
     * Get all tagged-based badges in alphabetical order.
     */
    TAG;
}
