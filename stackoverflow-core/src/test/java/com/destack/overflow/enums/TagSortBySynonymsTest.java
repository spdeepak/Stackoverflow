package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TagSortBySynonymsTest {

    @Test
    public void test() {
        assertFalse(TagSortBySynonyms.contains(null));
        assertTrue(TagSortBySynonyms.contains(TagSortBySynonyms.ACTIVITY));
        assertFalse(TagSortBySynonyms.validate(null));
        assertTrue(TagSortBySynonyms.validate(TagSortBySynonyms.ACTIVITY));
    }

}
