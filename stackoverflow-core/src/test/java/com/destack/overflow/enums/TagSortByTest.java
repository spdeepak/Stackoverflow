package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TagSortByTest {

    @Test
    public void test() {
        assertFalse(TagSortBy.isContains(null));
        assertTrue(TagSortBy.isContains(TagSortBy.ACTIVITY));
        assertFalse(TagSortBy.isValid(null));
        assertTrue(TagSortBy.isValid(TagSortBy.ACTIVITY));
    }

}
