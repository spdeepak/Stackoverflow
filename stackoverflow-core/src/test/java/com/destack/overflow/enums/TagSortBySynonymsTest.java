package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TagSortBySynonymsTest {

    @Test
    public void test() {
        assertFalse(TagSortBySynonyms.isContains(null));
        assertTrue(TagSortBySynonyms.isContains(TagSortBySynonyms.ACTIVITY));
        assertFalse(TagSortBySynonyms.isValid(null));
        assertTrue(TagSortBySynonyms.isValid(TagSortBySynonyms.ACTIVITY));
    }

}
