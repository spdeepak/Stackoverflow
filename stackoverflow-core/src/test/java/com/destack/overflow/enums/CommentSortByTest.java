package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CommentSortByTest {

    @Test
    public void test() {
        assertFalse(CommentSortBy.isContains(null));
        assertTrue(CommentSortBy.isContains(CommentSortBy.CREATION));
        assertFalse(CommentSortBy.isValid(null));
        assertTrue(CommentSortBy.isValid(CommentSortBy.CREATION));
    }

}
