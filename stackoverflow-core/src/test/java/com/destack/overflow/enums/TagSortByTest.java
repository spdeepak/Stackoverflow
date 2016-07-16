package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TagSortByTest {

    @Test
    public void test() {
        assertFalse(TagSortBy.contains(null));
        assertTrue(TagSortBy.contains(TagSortBy.ACTIVITY));
        assertFalse(TagSortBy.validate(null));
        assertTrue(TagSortBy.validate(TagSortBy.ACTIVITY));
    }

}
